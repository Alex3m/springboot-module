package academy.everyonecodes.endpoints;

import academy.everyonecodes.clients.JsonPlaceholderClient;
import academy.everyonecodes.data.Post;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostEndpoint {
    private final JsonPlaceholderClient client;

    public PostEndpoint(JsonPlaceholderClient client) {
        this.client = client;
    }

    @GetMapping
    List<Post> getList() {
        return client.getPostList();
    }

    @GetMapping("/{id}")
    Post getOnePost(@PathVariable int id) {
        return client.getPost(id);
    }

    @PostMapping
    Post post(@RequestBody Post post) {
        return client.postPost(post);
    }

    @PutMapping("/{id}")
    void putPost(@PathVariable int id, @RequestBody Post post) {
        client.putPostDTO(id, post);
    }

    @DeleteMapping
    void deleteAll() {
        client.deleteAll();
    }

    @DeleteMapping("{id}")
    void deleteOne(@PathVariable int id) {
        client.deleteOne(id);
    }
}
