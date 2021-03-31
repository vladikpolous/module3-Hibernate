package daoTasks;

import entities.User;

import java.util.List;

public interface FollowersDao {
    List<String> findAllFollowers(User user);
}
