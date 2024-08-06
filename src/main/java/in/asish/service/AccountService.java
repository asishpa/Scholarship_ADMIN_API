package in.asish.service;

import in.asish.bindings.LoginForm;
import in.asish.bindings.UnlockAccount;

public interface AccountService {
	public String login(LoginForm loginForm);
	public String forgotPwd(String email);
	public String unlockUserAcc(UnlockAccount unlockAccount);
	
	
}
