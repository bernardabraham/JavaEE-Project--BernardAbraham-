package rest;

import javax.inject.Inject;
import javax.security.auth.login.AccountNotFoundException;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;


import service.ProjectService;

@Path("/account")
public class ProjectController {

	@Inject
	private ProjectService service;

	@GET
	@Path("/getAll")
	public String getAllAccounts() {
		return this.service.getAllAccounts();
	}
	
	@POST
	@Path("/create")
	public String createAccount(String account) {
		return this.service.createAccount(account);
	}
	@DELETE
	@Path("/delete/{id}")
	public String deleteAccount(@PathParam("id") int id) throws AccountNotFoundException {
		return this.service.deleteAccount(id);
	}
	@POST
	@Path("/update/{id}")
	public String updateAccount(@PathParam("id") int id, String account) throws AccountNotFoundException {
		return this.service.updateAccount(id, account);
	}
}
