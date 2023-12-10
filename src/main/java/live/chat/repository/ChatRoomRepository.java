package live.chat.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import live.chat.entity.ChatRoom;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, String> {
	
	Optional<ChatRoom> findBySenderIdAndRecipientId(String senderId, String recipientId);
}
