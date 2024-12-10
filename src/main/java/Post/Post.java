package Post;

import User.User;
import jakarta.persistence.*;
import jakarta.transaction.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Specifică faptul că baza de date va genera automat valorile pentru acest câmp
    private int id;
    private String title;
    private String content;

    @ManyToOne
    @JoinColumn(name = "userid", nullable = false)
    private User user;

    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    private Date date;
    private Status status;
}
