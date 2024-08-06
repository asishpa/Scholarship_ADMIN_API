package in.asish.bindings;

import java.time.LocalDate;

import lombok.Data;

@Data
public class UserAccForm {
	private String fullName;
	private String email;
	private Long mobileNo;
	private String gender;
	private LocalDate dob;
	private Long adhaarNo;
	private String roleName;

}
