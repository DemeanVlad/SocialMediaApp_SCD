package Comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
@CrossOrigin
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping
    public Comment createComment(@RequestBody Comment comment) {
        return commentService.createComment(comment);
    }

    @GetMapping("/post/{postId}")
    public List<Comment> getAllCommentsForPost(@PathVariable Integer postId) { // Modificare: endpoint pentru comentariile unui post
        return commentService.getAllCommentsForPost(postId);
    }
/*
    @PutMapping("/{commentId}")
    public Comment updateComment(@PathVariable Integer commentId, @RequestBody Comment updatedComment) { // Modificare: endpoint pentru actualizarea comentariului
        return commentService.updateComment(commentId, updatedComment);
    }
*/
    @DeleteMapping("/{commentId}")
    public void deleteComment(@PathVariable Integer commentId) { // Modificare: endpoint pentru ștergerea comentariului
        commentService.deleteComment(commentId);
    }
}
