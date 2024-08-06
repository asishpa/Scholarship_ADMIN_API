package in.asish.service;

import java.util.List;

import in.asish.bindings.UserAccForm;

public interface UserService {
	public boolean createUserAccount(UserAccForm userAccForm);
	public List<UserAccForm> fetchUserAccounts();
	public List<UserAccForm> updateUserDetails(UserAccForm userAccForm);
	public String changeAccStatus(String accId,String status);
}
