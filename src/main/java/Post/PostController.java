package Post;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // pt manipulare cererilor http, va trimite json sau xml
@RequestMapping("/Post") // defineste ruta pt toate cererile http /post
@CrossOrigin //permite backendului sa faca cereri
public class PostController {
    @Autowired
    private  PostService postService;

    @PostMapping
    public Post create(@RequestBody Post post){
        return postService.create(post);
    }

    @GetMapping
    public List<Post> getAll(){
        return postService.findAllPosts();
    }

    /*@PutMapping
    public Post updatePost(@PathVariable Integer postId,@RequestBody Post updatedPost){
        return postService.updatePost(postId, updatedPost);
    }
     */

    @DeleteMapping("/{postId}")
    public void deletePost(@PathVariable Integer postId) { // Modificare: endpoint pentru delete
        postService.deletePost(postId);
    }


    @GetMapping("/published/{userId}")
    public List<Post> getAllPublishedPostsForUser(@PathVariable Integer userId) { // Modificare: endpoint pentru publicate
        return postService.getAllPublishedPostsForUser(userId);
    }
}
