package in.asish.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String user_id;
	private String user_name;
	private String user_email;
	private String user_pwd;
	private String user_phno;
	private String user_gender;
	private LocalDate user_dob;
	private Integer user_adhaar;
	private String active_switch;
	private String acc_status;
	private String role_name;
	private String confirmation_code;
	
}
