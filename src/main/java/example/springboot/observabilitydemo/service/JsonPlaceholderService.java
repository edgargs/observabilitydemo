package example.springboot.observabilitydemo.service;

import example.springboot.observabilitydemo.model.Post;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

public interface JsonPlaceholderService {

    @GetExchange("/posts")
    List<Post> loadPosts();
}
