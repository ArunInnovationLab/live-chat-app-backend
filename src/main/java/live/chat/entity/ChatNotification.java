package live.chat.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ChatNotification {


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	
	private String senderId;
	
	private String recipientId;
	
	private String content;

	
	
	public ChatNotification(String id, String senderId, String recipientId, String content) {
		super();
		this.id = id;
		this.senderId = senderId;
		this.recipientId = recipientId;
		this.content = content;
	}

	public ChatNotification(String senderId, String recipientId, String content) {
		super();
		this.senderId = senderId;
		this.recipientId = recipientId;
		this.content = content;
	}

	public ChatNotification() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSenderId() {
		return senderId;
	}

	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}

	public String getRecipientId() {
		return recipientId;
	}

	public void setRecipientId(String recipientId) {
		this.recipientId = recipientId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
	
	
}
