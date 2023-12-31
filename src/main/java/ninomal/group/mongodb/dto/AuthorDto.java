package ninomal.group.mongodb.dto;

import java.io.Serializable;

import ninomal.group.mongodb.domain.User;

public class AuthorDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	String id;
	String name;
	
	public AuthorDto() {
	}
	
	public AuthorDto(User obj) {
		id = obj.getId();
		name = obj.getName();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
		
	
}
