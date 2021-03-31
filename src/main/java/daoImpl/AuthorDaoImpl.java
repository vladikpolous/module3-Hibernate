package daoImpl;

import daoTasks.AuthorDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import util.HibernateSessionAnnotationFactoryUtil;

import java.util.List;

public class AuthorDaoImpl implements AuthorDao {
    SessionFactory sessionFactory = HibernateSessionAnnotationFactoryUtil.getSessionFactory();

    @Override
    public List<String> findAllAuthors() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("FROM User WHERE isAuthor = TRUE");
            List list = query.list();
            return list;
        }
    }

    @Override
    public List<String> findTopAuthors(int limit) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery(
                    "SELECT DISTINCT u.fullName FROM User AS u INNER JOIN Post AS p ON u.id = p.author WHERE u.id = p.author AND p.rating >=: rating");
            query.setParameter("rating", limit);
            List list = query.list();
            return list;
        }
    }
}
