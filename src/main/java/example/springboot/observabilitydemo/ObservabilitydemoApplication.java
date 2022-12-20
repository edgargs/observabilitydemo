package example.springboot.observabilitydemo;

import example.springboot.observabilitydemo.model.Post;
import example.springboot.observabilitydemo.repository.PostRepository;
import example.springboot.observabilitydemo.service.JsonPlaceholderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import java.util.List;

@SpringBootApplication
public class ObservabilitydemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ObservabilitydemoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(PostRepository postRepository) {
		return args -> {
			WebClient client = WebClient.builder().baseUrl("https://jsonplaceholder.typicode.com").build();
			HttpServiceProxyFactory factory = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(client)).build();
			JsonPlaceholderService jps = factory.createClient(JsonPlaceholderService.class);

			List<Post> posts = jps.loadPosts();
			postRepository.saveAll(posts);
		};
	}
}
