package entities;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean getisAuthor() {
        return isAuthor;
    }

    public void setisAuthor(boolean author) {
        this.isAuthor = author;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", isAuthor=" + isAuthor +
                ", isModerator=" + isModerator +
                '}';
    }

    public boolean getisModerator() {
        return isModerator;
    }

    public void setisModerator(boolean moderator) {
        this.isModerator = moderator;
    }

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "login")
    private String login;

    @Column(name = "email")
    private String email;

    @Column(name = "age")
    private int age;

    @Column(name = "is_author")
    private boolean isAuthor;

    @Column(name = "is_moderator")
    private boolean isModerator;



    public User() {
    }


}
