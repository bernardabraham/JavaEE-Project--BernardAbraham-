package persistence.repository;

import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import persistence.domain.User;
import util.JSONUtil;

@Default
public class TaskDatabase implements TaskRepository {
	JSONUtil util = new JSONUtil();
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	
	@Transactional(value = TxType.SUPPORTS)
	public String getAllAccounts() {
		TypedQuery<User> query = manager.createQuery("select a from ProjectAccount a", User.class);
		return this.util.getJSONForObject(query.getResultList());
	}

	@Transactional(value = TxType.REQUIRED)
	public String createAccount(String jsonStr) {
		User account1 = util.getObjectForJSON(jsonStr, User.class);
		manager.persist(account1);
		return "Success";

	}

	@Transactional(value = TxType.REQUIRED)
	public String deleteAccount(int id) {
		this.manager.remove(this.manager.find(User.class, id));
		return "Success";
	}

	@Transactional(value = TxType.REQUIRED)
	public String updateAccount(int id, String account) {
		User newAccount = util.getObjectForJSON(account, User.class);
		User existing = this.manager.find(User.class, id);
		existing.setUserName(newAccount.getUserName());
		existing.setPassword(newAccount.getUserName());
		existing.setEmail(newAccount.getUserName());
		manager.persist(existing);
		return "Success";
	}

}