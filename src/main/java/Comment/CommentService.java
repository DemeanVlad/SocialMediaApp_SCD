package Comment;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    
    @Autowired
    private CommentRepository commentRepository;

    @Transactional
    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public List<Comment> getAllCommentsForPost(Integer postId){
        return commentRepository.findByPostId(postId);
    }
    /* put dont work
@Transactional
    public Comment updateComment(Integer commentId,Comment updatedComment){
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new EntityNotFoundException("Comment not found"));
        comment.setContent(updatedComment.getContent());
        return commentRepository.save(comment);
    }
*/
    @Transactional
    public void deleteComment(Integer commentId){
        if(!commentRepository.existsById(commentId)){
            throw new EntityNotFoundException("comment not found" + commentId);
        }
        commentRepository.deleteById(commentId);
    }

}
