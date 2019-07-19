package persistence.repository;

import java.util.List;

import util.JSONUtil;

public class ProjectDatabase implements ProjectRepository {
	JSONUtil util = new JSONUtil();
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Transactional(value = TxType.SUPPORTS)
	public String getAllAccounts() {
		TypedQuery<ProjectAccount> query = manager.createQuery("select a from Account a", ProjectAccount.class)
	    return this.util.getJSONForObject(query.getResultList());
	}
	
	@Transactional(value = TxType.SUPPORTS)
	public List<ProjectAccount> lookUpAccounts(ProjectAccount a) {
		TypedQuery<ProjectAccount> query = manager.createQuery("select a from Account a", ProjectAccount.class);
		return query.getResultList();

		// (accountId, firstName, lastName, accountNumber)VALUE(1,'John','Doe',1234)
	}

	@Transactional(value = TxType.REQUIRED)
	public String createAccount(String jsonStr) {
		ProjectAccount account1 = util.getObjectForJSON(jsonStr, ProjectAccount.class);
		manager.persist(account1);
		return "Success";

	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public String deleteAccount(int id) {
		this.manager.remove(this.manager.find(ProjectAccount.class, id));
		return "Success";
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public String updateAccount(int id, String ProjectAccount) {
		ProjectAccount newAccount = util.getObjectForJSON(account, ProjectAccount.class);
		ProjectAccount existing = this.manager.find(ProjectAccount.class, id);
		existing.setLastName(newAccount.getFirstName());
		existing.setFirstName(newAccount.getFirstName());
		manager.persist(existing);
		return "Success";
	}

}
