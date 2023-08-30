package ninomal.group.mongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import ninomal.group.mongodb.domain.Post;
import ninomal.group.mongodb.domain.User;
import ninomal.group.mongodb.dto.AuthorDto;
import ninomal.group.mongodb.repository.PostRepository;
import ninomal.group.mongodb.repository.UserRepository;

@Configuration
public class Instantiaton implements CommandLineRunner {
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		postRepo.deleteAll();
		
		User maria = new User(null, "maria@gmail.com", "Maria Brown");
		User alex = new User(null,"alex@gmail.com", "Alex Green");
		User bob = new User(null, "bob@gmail.com", "Bob Grey");
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, new AuthorDto(maria), "indo viagem para italia", sdf.parse("10/06/2000"), "Vou viajar");
		Post post2 = new Post(null, new AuthorDto(alex), "nem li", sdf.parse("10/08/2022"), "recados");
		postRepo.saveAll(Arrays.asList(post1, post2));
	}

	
	
	
}
