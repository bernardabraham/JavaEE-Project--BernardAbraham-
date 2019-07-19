package service;


import javax.inject.Inject;
import javax.security.auth.login.AccountNotFoundException;

import persistence.repository.UserRepository;


public class UserServiceImpl implements UserService {

	@Inject
	private UserRepository repo;

	public String getAllAccounts() {
		return this.repo.getAllAccounts();
	}

	public String createAccount(String account) {
		return this.repo.createAccount(account);
	}

	public String deleteAccount(int Id) throws AccountNotFoundException {
		return this.repo.deleteAccount(Id);
	}

	public String updateAccount(int Id, String account) throws AccountNotFoundException {
		return this.repo.updateAccount(Id, account);
	}

}