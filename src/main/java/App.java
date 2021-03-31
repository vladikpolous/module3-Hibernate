import daoImpl.*;
import daoImpl.additionalDao.SafDao;
import daoTasks.FollowersDao;
import daoTasks.SubscriptionsDao;
import entities.Post;
import entities.PostStatus;
import entities.User;
import entities.additionalEntity.Saf;
import helpers.PostHelp;
import helpers.UserHelp;

import java.util.Scanner;

public class App {

        private static final String CREATE_USER = "Create user";
        private static final String DELETE_USER = "Delete user";
        private static final String SHOW_ALL_USERS = "Show users";
        private static final String UPDATE_USER = "Update user";
        private static final String FIND_BY_ID = "Find user by id";
        private static final String CREATE_POST = "Create post";
        private static final String FIND_POST_BY_ID = "Find post by id";
        private static final String SHOW_ALL_POSTS = "Show posts";
        private static final String DELETE_POST = "Delete post";
        private static final String UPDATE_POST = "Update post";
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("What do you want?");
            String choice = scanner.nextLine();
            switch (choice) {
                case CREATE_USER:
                    UserHelp.createUser(scanner);
                    break;
                case DELETE_USER:
                    UserHelp.deleteUser(scanner);
                    break;
                case SHOW_ALL_USERS:
                    UserHelp.showAllUsers();
                    break;
                case UPDATE_USER:
                    UserHelp.updateUser(scanner);
                    break;
                case FIND_BY_ID:
                    UserHelp.findById(scanner);
                    break;
                case CREATE_POST://
                    PostHelp.cratePost(scanner);
                    break;
                case FIND_POST_BY_ID://
                    PostHelp.findById(scanner);
                case SHOW_ALL_POSTS://
                    PostHelp.showAllPosts();
                case DELETE_POST:
                    PostHelp.deletePost(scanner);
                    break;
                case UPDATE_POST:
                    PostHelp.updatePost(scanner);
                default:
                    System.out.println("Something went wrong");
            }

            PostDao postDao = new PostDao();
            UserDao userDao = new UserDao();
            System.out.println(postDao.findAllPostsByAuthor(userDao.findById(2)));
            System.out.println(postDao.findTopPosts(4));
            System.out.println(postDao.findTopAuthorsPosts(userDao.findById(3),4 ));

            AuthorDaoImpl authorDao = new AuthorDaoImpl();
            System.out.println(authorDao.findAllAuthors());


            System.out.println(authorDao.findTopAuthors(9));
            User user1 = userDao.buildUser("one", "one", "@one", 20, true, false);
            User user2 = userDao.buildUser("two", "two", "@two", 25, false, true);
            User user3 = userDao.buildUser("three", "three", "three@", 20, true, false);

        Saf saf1 = new Saf(userDao.getUserWithId(user1), userDao.getUserWithId(user2));
        Saf saf2 = new Saf(userDao.getUserWithId(user1), userDao.getUserWithId(user3));
        SafDao safDao = new SafDao();

        safDao.insert(saf1);
        safDao.insert(saf2);


        FollowersDaoImpl followersDao = new FollowersDaoImpl();
        System.out.println(followersDao.findAllFollowers(userDao.getUserWithId(user1)));

        /*SubscriptionsDaoImpl implements SubscriptionsDao*/
        SubscriptionsDaoImpl subscriptionsDao = new SubscriptionsDaoImpl();
        System.out.println(subscriptionsDao.findAllSubscriptions(userDao.getUserWithId(user3)));
    }
}
