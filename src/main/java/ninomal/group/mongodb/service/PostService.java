package ninomal.group.mongodb.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ninomal.group.mongodb.domain.Post;
import ninomal.group.mongodb.repository.PostRepository;
import ninomal.group.mongodb.service.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository post;
	
	
	public Post findById(String id) {
		Optional<Post> obj = post.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("id not found"));
		}
	

}