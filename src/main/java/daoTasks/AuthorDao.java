package daoTasks;

import entities.User;

import java.util.List;

public interface AuthorDao {
    List<String> findAllAuthors();

    List<String> findTopAuthors(int limit);
}