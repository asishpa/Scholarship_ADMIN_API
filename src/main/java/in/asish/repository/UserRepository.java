package in.asish.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.asish.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String>{
	

}
