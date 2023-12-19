package live.chat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;



import live.chat.entity.User;
import live.chat.service.UserService;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "*")
@Controller
@RequiredArgsConstructor
public class UserController {

	@Autowired
	private UserService userService ;
	
	
	@MessageMapping("/user.addUser")
	@SendTo("/user/topic")
	public User addUser(@Payload User user) {
		System.out.println("adding usr");
		userService.saveUser(user);
		return user;
	}
	
	
	
	@MessageMapping("/user.disconnectUser")
	public User disconnect(@Payload User user) {
		
		userService.disconnectUser(user);
		return user;
		
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> findConnectedUsers(){
		return ResponseEntity.ok(userService.findConnectedUsers());
		
	}
}
