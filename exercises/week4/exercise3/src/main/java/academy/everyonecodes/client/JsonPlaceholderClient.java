package academy.everyonecodes.clients;

import academy.everyonecodes.data.Post;
import academy.everyonecodes.dto.PostDTO;
import academy.everyonecodes.dtotranslator.PostTranslator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Controller
public class JsonPlaceholderClient {
    private final RestTemplate restTemplate;
    private final PostTranslator postTranslator;
    private final String url;

    public JsonPlaceholderClient(RestTemplate restTemplate, PostTranslator postTranslator,
                                 @Value("${api.url}") String url) {
        this.restTemplate = restTemplate;
        this.postTranslator = postTranslator;
        this.url = url;
    }

    public List<Post> getPostList() {
        PostDTO[] postDTOs = restTemplate.getForObject(url, PostDTO[].class);
        return Arrays.stream(postDTOs)
                .map(postTranslator::translateToPost)
                .collect(toList());
    }

    public Post getPost(int id) {
        PostDTO postDTO = restTemplate.getForObject(url + "/" + id, PostDTO.class);
        return postTranslator.translateToPost(postDTO);
    }

    public Post postPost(Post post) {
        PostDTO postDTO = postTranslator.translateToDTO(post);
        PostDTO postDTORespond = restTemplate.postForObject(url, postDTO, PostDTO.class);
        return postTranslator.translateToPost(postDTORespond);
    }

    public void putPostDTO(int id, Post post) {
        PostDTO postDTO = postTranslator.translateToDTO(post);
        restTemplate.put(url + "/" + id, postDTO);
    }

    public void deleteAll() {
        restTemplate.delete(url);
    }

    public void deleteOne(int id) {
        restTemplate.delete(url + "/" + id);
    }
}
