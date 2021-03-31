package daoImpl;

import daoTasks.SubscriptionsDao;
import entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import util.HibernateSessionAnnotationFactoryUtil;

import java.util.List;

public class SubscriptionsDaoImpl implements SubscriptionsDao {
    SessionFactory sessionFactory = HibernateSessionAnnotationFactoryUtil.getSessionFactory();

    @Override
    public List<String> findAllSubscriptions(User user) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("SELECT u.login FROM User u INNER JOIN Saf s ON u.id = s.id " +
                    "WHERE s.id =: user AND s.id = u.id");
            query.setParameter("user", user);
            List list = query.list();
            return list;
        }
    }
}