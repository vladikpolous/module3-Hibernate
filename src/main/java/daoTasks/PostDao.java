package daoTasks;

import entities.Post;
import entities.User;

import java.util.List;

public interface PostDao {
    List<Post> findAllPostsByAuthor(User author);

    List<Post> findTopPosts(int limit);

    List<Post> findTopAuthorsPosts(User author, int limit);
}
