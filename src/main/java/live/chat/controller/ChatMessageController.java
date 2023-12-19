package live.chat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import live.chat.entity.ChatMessage;
import live.chat.entity.ChatNotification;
import live.chat.service.ChatMessageService;


@Controller
public class ChatMessageController {

	private SimpMessagingTemplate messagingTemplate;
	
	@Autowired
	private ChatMessageService chatMessageService;
	
	
	@MessageMapping("/chat")
	public void processMessage(@Payload ChatMessage chatMessage) {
		
		ChatMessage savedMessage = chatMessageService.save(chatMessage);
		messagingTemplate.convertAndSendToUser(chatMessage.getRecipientId(),"/queue/message", new ChatNotification(savedMessage.getId(), savedMessage.getSenderId(), savedMessage.getRecipientId(), savedMessage.getContent()));
		
	}
	
	
	
	@GetMapping("/messages/{senderId}/{recipientId}")
	public ResponseEntity<List<ChatMessage>> getMethodName(@PathVariable String senderId, @PathVariable String recipientId) {
		
		return ResponseEntity.ok(chatMessageService.findChatMessages(senderId, recipientId));
	}
	
	
	
}
