package live.chat.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

@Entity
public class User {

//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Integer id;

	@Id
	private String nickName;

	private String fullName;

	@Enumerated(EnumType.STRING)
	private Status status;

	public User(String nickName, String fullName, Status status) {
		super();
//		this.id = id;
		this.nickName = nickName;
		this.fullName = fullName;
		this.status = status;
	}

	public User() {
		super();
	}

//	public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
