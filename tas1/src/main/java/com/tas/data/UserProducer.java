package com.tas.data;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import com.tas.model.User;

@RequestScoped
public class UserProducer {

	@Inject
	private UserRepository UserRepository;

	private List<User> Users;

	private User searchUser = new User();

	@Produces
	@Named
	public List<User> getUsers() {
		return Users;
	}

	@Produces
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
		Users = UserRepository.findAllOrderedByName(searchUser);
	}
}
