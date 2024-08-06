package in.asish.service;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.asish.bindings.UserAccForm;
import in.asish.entity.UserEntity;
import in.asish.repository.UserRepository;
import in.asish.utils.EmailUtils;

@Service
public class UserAccountServiceImpl implements UserService{
	
	@Autowired
	private EmailUtils emailUtils;
	
	@Autowired
	private UserRepository userRepository;
	
	private static final SecureRandom RANDOM = new SecureRandom();
	@Override
	public boolean createUserAccount(UserAccForm userAccForm) {
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(userAccForm, userEntity);
		
		userEntity.setAcc_status("LOCKED");
		userEntity.setActive_switch("Y");
		userEntity.setConfirmation_code(generateRegistrationCode(userEntity.getUser_email()));
		userRepository.save(userEntity);
		String subject = "User Registration";
		String body = readEmail(subject, userEntity);
		
		
		return emailUtils.sendEmail(subject, body, userAccForm.getEmail()); 
	}

	@Override
	public List<UserAccForm> fetchUserAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserAccForm> updateUserDetails(UserAccForm userAccForm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String changeAccStatus(String accId, String status) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private String readEmail(String filename,UserEntity user) {
		StringBuilder sb = new StringBuilder();
		try(Stream<String> lines = Files.lines(Paths.get(filename))){
				lines.forEach(line -> {
					line = line.replace("${FNAME}", user.getUser_name());
					line = line.replace("${TEMP_PWD}", user.getUser_pwd());
					line = line.replace("${CODE}", user.getConfirmation_code());
					
				});
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
		}
	 private String generateRegistrationCode(String email) {
	        byte[] randomBytes = new byte[24];
	        RANDOM.nextBytes(randomBytes);
	        String token = email + new String(randomBytes);

	        return hashWithSHA256(token);
	    }

	    private String hashWithSHA256(String input) {
	        try {
	            MessageDigest digest = MessageDigest.getInstance("SHA-256");
	            byte[] encodedHash = digest.digest(input.getBytes());
	            StringBuilder hexString = new StringBuilder(2 * encodedHash.length);
	            for (byte b : encodedHash) {
	                String hex = Integer.toHexString(0xff & b);
	                if (hex.length() == 1) {
	                    hexString.append('0');
	                }
	                hexString.append(hex);
	            }
	            return hexString.toString();
	        } catch (NoSuchAlgorithmException e) {
	            throw new RuntimeException(e);
	        }


	    }

}
