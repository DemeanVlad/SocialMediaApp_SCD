package Post;
//INTERACTIONEAZA DIRECT CU BAZA DE DATE
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
    @Query("SELECT p FROM Post WHERE p.status = 'PUBLISHED' AND p.user.id=:userId")
    // Modificare: query pentru postările publicate ale unui utilizator
    List<Post> getAllPublishedPostsForUser(@Param("userId")Integer userId);
}
