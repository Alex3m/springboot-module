package academy.everyonecodes.dtotranslator;

import academy.everyonecodes.data.Post;
import academy.everyonecodes.dto.PostDTO;
import org.springframework.stereotype.Service;

@Service
public class PostTranslator {

    public PostDTO translateToDTO(Post post) {
        String title = post.getTitle();
        String body = post.getContent();
        int userID = post.getUser();
        int id = post.getIdentifier();
        return new PostDTO(title, body, userID, id);
    }
    public Post translateToPost(PostDTO postDTO) {
        String title = postDTO.getTitle();
        String content = postDTO.getBody();
        int user = postDTO.getUserId();
        int identifier = postDTO.getId();
        return new Post(title, content, user, identifier);
    }
}
