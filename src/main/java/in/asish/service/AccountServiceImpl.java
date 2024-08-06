package in.asish.service;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import in.asish.bindings.LoginForm;
import in.asish.bindings.UnlockAccount;
import in.asish.constants.AppConstants;
import in.asish.entity.UserEntity;

public class AccountServiceImpl implements AccountService{

	@Override
	public String login(LoginForm loginForm) {
		
		return null;
	}

	@Override
	public String forgotPwd(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String unlockUserAcc(UnlockAccount unlockAccount) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private String readEmailBody(String fileName,UserEntity user) {
		StringBuilder sb = new StringBuilder();
		try(Stream<String> lines = Files.lines(Paths.get(fileName))) {
			lines.forEach(line -> {
				line = line.replace(AppConstants.FNAME, user.getUser_name());
				line = line.replace(AppConstants.PWD, user.getUser_pwd());
				line = line.replace(AppConstants.EMAIL, user.getUser_email());
				
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	
}
