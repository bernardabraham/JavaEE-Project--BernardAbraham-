package persistence.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import persistence.domain.ProjectAccount;
import util.JSONUtil;

public class ProjectDatabase implements ProjectRepository {
	JSONUtil util = new JSONUtil();
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	
	@Transactional(value = TxType.SUPPORTS)
	public String getAllAccounts() {
		TypedQuery<ProjectAccount> query = manager.createQuery("select a from Account a", ProjectAccount.class);
		return this.util.getJSONForObject(query.getResultList());
	}

	@Transactional(value = TxType.REQUIRED)
	public String createAccount(String jsonStr) {
		ProjectAccount account1 = util.getObjectForJSON(jsonStr, ProjectAccount.class);
		manager.persist(account1);
		return "Success";

	}

	@Transactional(value = TxType.REQUIRED)
	public String deleteAccount(int id) {
		this.manager.remove(this.manager.find(ProjectAccount.class, id));
		return "Success";
	}

	@Transactional(value = TxType.REQUIRED)
	public String updateAccount(int id, String account) {
		ProjectAccount newAccount = util.getObjectForJSON(account, ProjectAccount.class);
		ProjectAccount existing = this.manager.find(ProjectAccount.class, id);
		existing.setUserName(newAccount.getUserName());
		existing.setPassword(newAccount.getUserName());
		existing.setEmail(newAccount.getUserName());
		manager.persist(existing);
		return "Success";
	}

}
