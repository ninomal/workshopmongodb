package ninomal.group.mongodb.dto;

import java.io.Serializable;

import ninomal.group.mongodb.domain.User;

public class UserDto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	private String email;
	private String name;
	private String id;
	
	public UserDto() {
	}

	
	public UserDto(User obj){
		this.id = obj.getId();
		this.email = obj.getEmail();
		this.name = obj.getName();
	}
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	
}
