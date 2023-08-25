package ninomal.group.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import ninomal.group.mongodb.domain.User;

public interface UserRepository extends MongoRepository<User, String>{
	

}
