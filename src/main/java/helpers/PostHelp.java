package helpers;



import daoImpl.PostDao;
import daoImpl.UserDao;
import entities.Post;
import entities.PostStatus;
import entities.User;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PostHelp {
    private static final UserDao userDao = new UserDao();
    private static final PostDao postDao = new PostDao();
    public static void cratePost(Scanner scanner){
        System.out.println("Enter title");
        String tittle = scanner.nextLine();

        System.out.println("Enter content");
        String content = scanner.nextLine();

        UserHelp.showAllUsers();

        System.out.println("Enter ID of Author");
        int idAuthor = scanner.nextInt();
        User user = userDao.findById(idAuthor);

        System.out.println("Enter ID of Moderator");
        int Moderator = scanner.nextInt();
        User user1 = userDao.findById(Moderator);
        /*System.out.println(Arrays.toString(PostStatus.values()));*/
        PostStatus postStatus = PostStatus.DRAFT;


        System.out.println("Enter raring");
        int rating = scanner.nextInt();


        Post post = new Post(tittle,content,user,user1,rating, postStatus);
        postDao.create(post);
    }
    public static void findById(Scanner scanner){
        System.out.println("Please, enter id");
        int id = scanner.nextInt();
        System.out.println(postDao.findById(id));
    }
    public static void showAllPosts(){
        List<Post> listOfPosts = postDao.findAll();
        if(listOfPosts.size() == 0){
            System.out.println("List is empty");
        }
        for (Post post: listOfPosts) {
            System.out.println(post);
        }
    }
    public static void deletePost(Scanner scanner){
        System.out.println("Enter ID of post");
        int id = scanner.nextInt();
        postDao.deleteById(id);
    }
    public static void updatePost(Scanner scanner){
        /*showAllPosts();*/

        System.out.println("Enter title of post");
        String title = scanner.nextLine();


        System.out.println("Enter content of post");
        String content = scanner.nextLine();



        System.out.println("Enter ID of Author");
        int idAuthor = scanner.nextInt();
        User user = userDao.findById(idAuthor);

        System.out.println("Enter ID of Moderator");
        int Moderator = scanner.nextInt();
        User user1 = userDao.findById(Moderator);

        System.out.println("Please, enter rating of user");
        int rating = scanner.nextInt();

        System.out.println("Please, enter post's id that you want to change information");
        int id = scanner.nextInt();

        PostStatus status = PostStatus.WORKSHEET;
        Post post = new Post(title,content,user,user1,rating,status);
        postDao.update(post,id);


    }
}
