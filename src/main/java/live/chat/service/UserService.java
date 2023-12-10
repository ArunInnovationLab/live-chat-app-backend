package live.chat.service;

import java.util.List;

import org.springframework.stereotype.Service;

import live.chat.entity.Status;
import live.chat.entity.User;
import live.chat.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private UserRepository userRepository;
	

	// when user connects - save that user
	public void saveUser(User user) {
		
		user.setStatus(Status.ONLINE);
		
		userRepository.save(user);
	}
	
	
	public void disconnectUser(User user) {
		
		User storedUser = userRepository.findById(user.getNickName()).orElse(null);
		
		if(storedUser != null) {
			
			storedUser.setStatus(Status.OFFLINE);
			
			userRepository.save(storedUser);
		}
	}
	
	
	public List<User> findConnectedUsers(){
		
		return userRepository.findAllByStatus(Status.ONLINE);
	}
}
