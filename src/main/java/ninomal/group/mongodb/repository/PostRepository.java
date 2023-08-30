package ninomal.group.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import ninomal.group.mongodb.domain.Post;


public interface PostRepository extends MongoRepository<Post, String>{

	

}
