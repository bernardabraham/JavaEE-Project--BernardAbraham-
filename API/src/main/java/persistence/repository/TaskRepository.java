package persistence.repository;

public interface TaskRepository{
	
	String getAllAccounts();
	String createAccount(String account);
	String deleteAccount(int id);
	String updateAccount(int id, String account);

}
