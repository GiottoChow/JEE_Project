package com.tas.controller;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.tas.model.User;
import com.tas.service.UserRegistration;

@Model
public class UserController {

	@Inject
	private FacesContext facesContext;

	@Inject
	private UserRegistration UserRegistration;

	private User newUser;

	@Produces
	@Named
	public User getNewUser() {
		return newUser;
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

	@PostConstruct
	public void initNewUser() {
		newUser = new User();
	}

	public String merge() {
		try {
			UserRegistration.merge(newUser);
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

	public void search() {
		try {
			facesContext.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_INFO, "Search Complete!",
					"Search Complete"));
		} catch (Exception e) {
			String errorMessage = getRootErrorMessage(e);
			facesContext.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, errorMessage,
					"Error, unsuccessful"));
		}
	}

	public void delete() {
		try {
			UserRegistration.delete(newUser);
			facesContext.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_INFO, "Delete Successful!",
					"Delete Successful"));
			initNewUser();
		} catch (Exception e) {
			String errorMessage = getRootErrorMessage(e);
			facesContext.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, errorMessage,
					"Error, unsuccessful"));
		}
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
