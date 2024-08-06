package in.asish.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "plan_dtls")
@Data
public class PlanEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String plan_id;
	private String plan_name;
	private String plan_start_date;
	private String plan_end_date;
}
