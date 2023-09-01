package ninomal.group.mongodb.service;

import java.util.Date;
import java.util.List;
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
	
	public List<Post> findByTitle(String text){
		return post.findyByTitle(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate){
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 *1000);
		return post.findAllTitle(text, minDate, maxDate);
		
	}

}
