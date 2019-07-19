package service;


import javax.inject.Inject;
import javax.security.auth.login.AccountNotFoundException;

import persistence.repository.ProjectRepository;


public class ProjectAccountServiceImpl implements ProjectAccountService {

	@Inject
	private ProjectRepository repo;

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