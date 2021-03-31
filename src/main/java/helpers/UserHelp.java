package helpers;



import daoImpl.UserDao;
import entities.User;

import java.util.List;
import java.util.Scanner;

public class UserHelp {
    private static final UserDao userDao = new UserDao();


    public static void createUser(Scanner scanner){
        System.out.println("Enter Full name of user");
        String fullName = scanner.nextLine();

        System.out.println("Enter login of user");
        String login = scanner.nextLine();

        System.out.println("Enter email of user");
        String email = scanner.nextLine();
        if(!email.contains("@")){
            System.out.println("Please, enter the correct email");
            return;
        }

        System.out.println("Please, enter age of user");
        int age = scanner.nextInt();
        if(age <18){
            System.out.println("You can not register");
        }

        System.out.println("This user is Author(Answer: true or false)");

        boolean isModerator;
        boolean isAuthor = scanner.hasNext();
        if(isAuthor == true){
             isModerator = false;
        } else{
             isModerator = true; // user can be Author OR Moderator
        }


        User user = userDao.buildUser(fullName,login,email,age,isAuthor,isModerator);
        userDao.create(user);
    }

    public static void deleteUser(Scanner scanner){
        System.out.println("Enter ID of user");
        int id = scanner.nextInt();
        userDao.deleteById(id);
    }

    public static void showAllUsers(){
        List<User> listOfUsers = userDao.findAll();
        if(listOfUsers.size() == 0){
            System.out.println("List is empty");
        }
        for (User user: listOfUsers) {
            System.out.println(user);
        }
    }

    public static void findById(Scanner scanner){
        System.out.println("Please, enter id");
        int id = scanner.nextInt();
        System.out.println(userDao.findById(id));
    }
    public static void updateUser(Scanner scanner){
        showAllUsers();

        System.out.println("Enter Full name of user");
        String fullName = scanner.nextLine();


        System.out.println("Enter login of user");
        String login = scanner.nextLine();

        System.out.println("Enter email of user");
        String email = scanner.nextLine();
        if(!email.contains("@")){
            System.out.println("Please, enter the correct email");
        }

        System.out.println("Please, enter age of user");
        int age = scanner.nextInt();
        if(age <18){
            System.out.println("You can not register");
        }
        System.out.println("Please, enter user's id that you want to change information");
        int id = scanner.nextInt();
        System.out.println("This user is Author(Answer: true or false)");

        boolean isModerator;
        boolean isAuthor = scanner.hasNext();
        if(isAuthor == true){
            isModerator = false;
        } else{
            isModerator = true; // user can be Author OR Moderator
        }

        User user = userDao.buildUser(fullName,login,email,age,isAuthor,isModerator);
        userDao.update(user,id);
    }
}
