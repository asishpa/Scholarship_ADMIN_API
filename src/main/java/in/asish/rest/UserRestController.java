package in.asish.rest;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.asish.bindings.UserAccForm;
import in.asish.service.UserService;

@RestController
public class UserRestController {
	
	@Autowired
	private UserService userService;
	
	private Logger logger = LoggerFactory.getLogger(UserRestController.class);
	@PostMapping("/user")
	public ResponseEntity<String> createUser(@RequestBody UserAccForm userAccForm) {
		logger.debug("Account craetion process started....");
		boolean userAccount = userService.createUserAccount(userAccForm);
		if(userAccount) {
			logger.debug("Account created successfully");
			return new ResponseEntity<>("Account created", HttpStatus.CREATED);
		}
		else {
			logger.debug("Account creation failed");
			return new ResponseEntity<String>("Account creation failed", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}
