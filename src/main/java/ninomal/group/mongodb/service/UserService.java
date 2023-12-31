package ninomal.group.mongodb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ninomal.group.mongodb.domain.User;
import ninomal.group.mongodb.dto.UserDto;
import ninomal.group.mongodb.repository.UserRepository;
import ninomal.group.mongodb.service.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("id not found"));
		}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User update(User obj) {
		User newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
		}
	

	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
		
	}

	public User fromDto(UserDto objDto) {
		return new User(objDto.getId(), objDto.getEmail(), objDto.getName());
	}
	
}
