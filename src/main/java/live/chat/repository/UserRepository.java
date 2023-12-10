package live.chat.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import live.chat.entity.Status;
import live.chat.entity.User;


public interface  UserRepository extends JpaRepository<User, String> {

	List<User> findAllByStatus(Status status);;
			
}
