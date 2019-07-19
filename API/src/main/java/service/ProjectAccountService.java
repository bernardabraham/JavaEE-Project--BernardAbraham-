package service;

import javax.security.auth.login.AccountNotFoundException;


public interface ProjectAccountService {
	String getAllAccounts();

	String createAccount(String account);

	String deleteAccount(int accountId) throws AccountNotFoundException;

	String updateAccount(int accountId, String account) throws AccountNotFoundException;


}