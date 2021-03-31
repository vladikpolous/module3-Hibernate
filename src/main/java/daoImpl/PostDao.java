package daoImpl;

import daoTasks.Dao;
import entities.Post;
import entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import util.HibernateSessionAnnotationFactoryUtil;

import java.util.List;

public class PostDao implements Dao<Post>, daoTasks.PostDao {
    SessionFactory sessionFactory = HibernateSessionAnnotationFactoryUtil.getSessionFactory();
    @Override
    public void create(Post post) {
        try (Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.save(post);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Post post, int id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("UPDATE Post " +
                    "SET " +
                    "title =: title, " +
                    "content =: content, " +
                    "author =: author, " +
                    "moderator =: moderator, " +
                    "rating =: rating, " +
                    "status =: status " +
                    "WHERE id =: id");
            query.setParameter("title", post.getTitle());
            query.setParameter("content", post.getContent());
            query.setParameter("author", post.getAuthor());
            query.setParameter("moderator", post.getModerator());
            query.setParameter("rating", post.getRating());
            query.setParameter("status", post.getStatus());
            query.setParameter("id", session.get(Post.class, id).getId());
            query.executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Override
    public Post findById(int id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("FROM  Post where id =: id", Post.class);
            query.setParameter("id",id);
            Post resultList = (Post) query.getResultList();
            session.getTransaction().commit();
            return  resultList;
        }
    }

    @Override
    public List<Post> findAll() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("FROM Post ");
            List list = query.getResultList();
            return list;
        }
    }

    @Override
    public void deleteById(int id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("DELETE FROM Post WHERE id =: id");
            query.setParameter("id", id);
            query.executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Override
    public List<Post> findAllPostsByAuthor(User author) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("FROM Post " +
                    "WHERE id =: id");
            query.setParameter("id", author);
            List list = query.list();
            session.getTransaction().commit();
            return list;
        }
    }

    @Override
    public List<Post> findTopPosts(int limit) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("FROM Post " +
                    "WHERE rating >=: rating");
            query.setParameter("rating", limit);
            List list = query.list();
            session.getTransaction().commit();
            return list;
        }
    }

    @Override
    public List<Post> findTopAuthorsPosts(User author, int limit) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("FROM Post WHERE rating >=: rating AND author =: author");
            query.setParameter("rating", limit);
            query.setParameter("author", author);
            List list = query.list();
            session.getTransaction().commit();
            return list;
        }
    }

    /*public  Post buildUser(String title, String content, User userAuthor, User userModerator, int rating, PostStatus postStatus){
        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        post.setAuthor(userAuthor);
        post.setModerator(userModerator);
        post.setRating(rating);
        post.setStatus(postStatus);
        return post;
    }*/
}
