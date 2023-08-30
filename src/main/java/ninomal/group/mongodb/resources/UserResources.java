package ninomal.group.mongodb.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import ninomal.group.mongodb.domain.Post;
import ninomal.group.mongodb.domain.User;
import ninomal.group.mongodb.dto.UserDto;
import ninomal.group.mongodb.service.UserService;

@RestController
@RequestMapping(value= "/users")
public class UserResources {
	
	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<UserDto>> findAll(){
		List<User> list = service.findAll();
		List<UserDto> listDto = list.stream().map(x -> new UserDto(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDto> findById(@PathVariable String id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(new UserDto(obj));
	}
	
	@DeleteMapping("/{id}")
 	public ResponseEntity<Void> delete(@PathVariable String id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping
	public  ResponseEntity<UserDto>  insert(@RequestBody UserDto objDto){
		User obj = service.fromDto(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri(); 
		return ResponseEntity.created(uri).build();
	}
	

	@PutMapping("/{id}")
	public  ResponseEntity<UserDto>  update(@RequestBody UserDto objDto, @PathVariable String id){
		User obj = service.fromDto(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = "/{id}/{posts}")
	public ResponseEntity<List<Post>> findPost(@PathVariable String id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj.getPost());
	}
	
	
}
