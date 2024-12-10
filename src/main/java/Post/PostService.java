package Post;
//FACE LOGICA DIN SPATE

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Transactional
    public Post create(Post post) {
        return postRepository.save(post);
    }

    public List<Post> findAllPosts() {
        return postRepository.findAll();
    }
/* O LAS ASA PUTIN CA N ARE LA CE FACE POST

    @Transactional
    public Post updatePost(Integer postId, Post updatedPost) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new EntityNotFoundException("Post not found with id " + postId));

        post.setTitle(updatedPost.getTitle());
        post.setContent(updatedPost.getContent());
        post.setStatus(updatedPost.getStatus()); // Modificare: actualizare status
        return postRepository.save(post);
    }
*/
    @Transactional
   public void deletePost(Integer postId){
        if(!postRepository.existsById(postId)){
            throw new EntityNotFoundException("Post not found"+postId);
        }
        postRepository.deleteById(postId);
    }

    public List<Post> getAllPublishedPostsForUser(Integer userId) { // Modificare: metodă pentru obținerea postărilor publicate
        return postRepository.getAllPublishedPostsForUser(userId);
    }
}
