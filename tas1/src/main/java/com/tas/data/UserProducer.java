package com.tas.data;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import com.tas.model.User;
import com.tas.service.UserRegistration;

@Named
@RequestScoped
public class UserProducer {

	@Inject
	FacesContext facesContext;

	@Inject
	UserRegistration userRegistration;

	@Inject
	private UserRepository userRepository;

	private List<User> Users;

	private User searchUser = new User();

	@Produces
	@Named
	public List<User> getUsers() {
		return Users;
	}

	@Named
	public User getSearchUser() {
		return searchUser;
	}

	public void onUserListChanged(
			@Observes(notifyObserver = Reception.IF_EXISTS) final User User) {
		retrieveAllUsersOrderedByName();
	}

	@PostConstruct
	public void retrieveAllUsersOrderedByName() {
		Users = userRepository.findAllOrderedByName(searchUser);
	}

	@Named
	public String login() {

		if (searchUser.getUserId() == null) {
			facesContext.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "User ID is empty",
					"User Id is empty"));
		}

		if (searchUser.getPasswd() == null) {
			facesContext.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Password is empty",
					"Password is empty"));
		}

		User targetUser = userRepository.findById(searchUser.getUserId());
		if (targetUser != null
				&& searchUser.getPasswd().equals(targetUser.getPasswd())) {

			HttpSession session = (HttpSession) facesContext
					.getExternalContext().getSession(false);
			targetUser.setLastSessionId(session.getId());
			userRegistration.merge(targetUser);
			session.setAttribute("user", targetUser);

			return "index.jsf";
		}

		facesContext.addMessage(null, new FacesMessage(
				FacesMessage.SEVERITY_ERROR, "Invalid credential",
				"Invalid credential"));
		return "#";
	}

}
