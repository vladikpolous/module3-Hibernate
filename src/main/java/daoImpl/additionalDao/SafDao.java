package daoImpl.additionalDao;

import entities.additionalEntity.Saf;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateSessionAnnotationFactoryUtil;

public class SafDao {
    SessionFactory sessionFactory = HibernateSessionAnnotationFactoryUtil.getSessionFactory();
    public void insert(Saf model) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(model);
            session.getTransaction().commit();
        }
    }
}
