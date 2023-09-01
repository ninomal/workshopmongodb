package ninomal.group.mongodb.resources;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ninomal.group.mongodb.domain.Post;
import ninomal.group.mongodb.resources.util.URL;
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
	
	@GetMapping(value= "/titlesearch")
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text){
		text = URL.decoparam(text);
		List<Post> list = post.findByTitle(text);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value= "/searchall")
	public ResponseEntity<List<Post>> findByAll(
			@RequestParam(value = "text", defaultValue = "") String text,
			@RequestParam(value = "minDate", defaultValue = "") String minDate,
			@RequestParam(value = "maxDate", defaultValue = "") String maxDate){
		text = URL.decoparam(text);
		Date minD = URL.convertDate(minDate, new Date(0l));
		Date mAx = URL.convertDate(maxDate, new Date());
		List<Post> list = post.fullSearch(text, minD, mAx);
		return ResponseEntity.ok().body(list);
	}
	
}
