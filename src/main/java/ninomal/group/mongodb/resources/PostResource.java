package ninomal.group.mongodb.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ninomal.group.mongodb.domain.Post;
import ninomal.group.mongodb.service.PostService;

@RestController
@RequestMapping(value="/posts")
public class PostResource {
	
	@Autowired
	private PostService post;
	
	@GetMapping(value= "/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id){
		Post obj = post.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	

	
	
}
