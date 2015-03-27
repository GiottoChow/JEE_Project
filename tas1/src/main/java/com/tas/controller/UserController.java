package com.tas.controller;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import com.tas.model.User;
import com.tas.service.UserRegistration;

@Model
public class UserController {

	@Inject
	private FacesContext facesContext;

	@Inject
	private UserRegistration userRegistration;

	private User newUser;

	private boolean isEdit = false;

	@Named
	public boolean isEdit() {
		return isEdit;
	}

	@Named
	public void setNewUser(User user) {
		newUser = user;
	}

	@Produces
	@Named
	public User getNewUser() {
		return newUser;
	}

	@PostConstruct
	public void initNewUser() {
		newUser = new User();
	}

	private String getRootErrorMessage(Exception e) {
		String errorMessage = "Registration failed. Please contract application support.";
		if (e == null) {
			return errorMessage;
		}

		Throwable t = e;
		while (t != null) {
			errorMessage = t.getLocalizedMessage();
			t = t.getCause();
		}
		return errorMessage;
	}

	@Named
	public String navToEdit(User user) {
		newUser = user;
		isEdit = true;
		return "user.jsf";
	}

	@Named
	public String merge() {
		try {
			userRegistration.merge(newUser);
			facesContext.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_INFO, "Successful!", "Successful"));
			initNewUser();
			return "findUser.jsf";
		} catch (Exception e) {
			String errorMessage = getRootErrorMessage(e);
			facesContext.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, errorMessage,
					"Error, unsuccessful"));
			return "#";
		}
	}

	@Named
	public void delete() {
		try {
			userRegistration.delete(newUser);
			facesContext.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_INFO, "Delete Successful!",
					"Delete Successful"));
		} catch (Exception e) {
			String errorMessage = getRootErrorMessage(e);
			facesContext.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, errorMessage,
					"Error, unsuccessful"));
		}
	}

	@Named
	public String logout() {
		HttpSession session = (HttpSession) facesContext.getExternalContext()
				.getSession(false);
		User targetUser = (User) session.getAttribute("user");
		targetUser.setLastSessionId(null);
		userRegistration.merge(targetUser);
		session.removeAttribute("user");
		session.invalidate();
		initNewUser();
		return "login.jsf";
	}

	// public void active() {
	// try {
	//
	// facesContext.getCurrentInstance().getExternalContext()
	// .getSession(true);
	// newUser.active();
	//
	// UserRegistration.merge(newUser);
	// facesContext.addMessage(null, new FacesMessage(
	// FacesMessage.SEVERITY_INFO, "Successful!", "Successful"));
	// initNewUser();
	// } catch (Exception e) {
	// String errorMessage = getRootErrorMessage(e);
	// facesContext.addMessage(null, new FacesMessage(
	// FacesMessage.SEVERITY_ERROR, errorMessage,
	// "Error, unsuccessful"));
	// }
	// }

}
