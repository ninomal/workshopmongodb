package ninomal.group.mongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import ninomal.group.mongodb.domain.Post;


public interface PostRepository extends MongoRepository<Post, String>{
	
	@Query("{ 'title' : { $regex: '?0', $options: 'i' } }")
	List<Post> findyByTitle(String text);
	
	List<Post> findByTitleContainingIgnoreCase(String text);
	

}
