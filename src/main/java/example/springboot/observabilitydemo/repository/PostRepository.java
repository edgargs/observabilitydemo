package example.springboot.observabilitydemo.repository;

import example.springboot.observabilitydemo.model.Post;
import org.springframework.data.repository.ListCrudRepository;

public interface PostRepository extends ListCrudRepository<Post, Integer> {
}
