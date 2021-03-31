package daoTasks;

import entities.User;

import java.util.List;

public interface SubscriptionsDao {
    List<String> findAllSubscriptions(User user);
}
