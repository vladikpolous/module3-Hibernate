package daoImpl;

import daoTasks.Dao;
import entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import util.HibernateSessionAnnotationFactoryUtil;

import java.util.List;

public class UserDao implements Dao<User> {
    SessionFactory sessionFactory = HibernateSessionAnnotationFactoryUtil.getSessionFactory();

    @Override
    public void create(User user) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(User user, int id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("UPDATE User " +
                    "SET " +
                    "fullName =: fullName, " +
                    "login =: login, " +
                    "email =: email, " +
                    "age =: age, " +
                    "isAuthor =: isAuthor, " +
                    "isModerator =: isModerator "+
                    "WHERE id =: id");
            query.setParameter("fullName", user.getFullName());
            query.setParameter("login", user.getLogin());
            query.setParameter("email", user.getEmail());
            query.setParameter("age", user.getAge());
            query.setParameter("isAuthor", user.getisAuthor());
            query.setParameter("isModerator", user.getisModerator());
            query.setParameter("id", session.get(User.class, id).getId());
            query.executeUpdate();
            session.getTransaction().commit();
        }

    }

    @Override
    public User findById(int id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("  FROM  User where id =: id", User.class);
            query.setParameter("id",id);
            User resultList = (User) query.getSingleResult();
            session.getTransaction().commit();
            return  resultList;
        }
    }

    @Override
    public List<User> findAll() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query<User> query = session.createQuery("FROM User ORDER BY id", User.class);
            List<User> resultList = query.getResultList();
            session.getTransaction().commit();
            return resultList;
        }
    }

    @Override
    public void deleteById(int id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("DELETE FROM User WHERE id =: id");
            query.setParameter("id", id);
            query.executeUpdate();
            session.getTransaction().commit();
        }

    }
    public User getUserWithId(User module) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("FROM User WHERE login =: login");
            query.setParameter("login", module.getLogin());
            List list = query.list();
            return (User) list.get(0);
        }
    }
    public  User buildUser( String fullName,String login ,String email,int age,boolean isAuthor, boolean isModerator){
        User user = new User();
        user.setFullName(fullName);
        user.setLogin(login);
        user.setEmail(email);
        user.setAge(age);
        user.setisAuthor(isAuthor);
        user.setisModerator(isModerator);
        return user;
    }
}
