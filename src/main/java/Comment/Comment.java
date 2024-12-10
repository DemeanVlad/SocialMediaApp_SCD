package Comment;

import User.User;
import Post.Post;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="post_id",nullable = false) //modif relatia manytoone cu post
    private Post post;

    @ManyToOne
    @JoinColumn(name="user_id",nullable = false) //modif relatia manytoone cu user
    private User user;

    @CreationTimestamp
    @Column(updatable = false, nullable = false) // Modificare: setare automată a datei de creare
    private Date createdOn;


    private String content;
}
