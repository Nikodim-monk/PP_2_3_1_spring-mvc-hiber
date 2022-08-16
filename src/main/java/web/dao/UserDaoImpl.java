package web.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import web.model.User;
import web.util.Util;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
        private SessionFactory sessionFactory = Util.mineHiberConnection();
////    @Autowired
////    private SessionFactory sessionFactory;

    public List<User> getAllUsers() {
        List<User> users;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            users = session.createQuery("SELECT i FROM User i", User.class).getResultList();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    public User getUserById(int id) {
        User user;
        try (Session session = sessionFactory.getCurrentSession()) {
            try {
                session.beginTransaction();
                user = session.get(User.class, id);
                session.getTransaction().commit();
            } catch (HibernateException e) {
                throw new RuntimeException(e);
            }
        }
        return user;
    }

    public void addNewUser(User user) {
        try (Session session = sessionFactory.getCurrentSession()) {
            try {
                session.beginTransaction();
                session.save(user);
                session.getTransaction().commit();
            } catch (HibernateException e) {
                session.getTransaction().rollback();
                throw new RuntimeException(e);
            }
        }
    }

    public void updateUser(User user, int id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            try {
                session.beginTransaction();
                User updateUser = session.get(User.class, id);
                updateUser.setName(user.getName());
                updateUser.setAge(user.getAge());
                session.getTransaction().commit();
            } catch (HibernateException e) {
                session.getTransaction().rollback();
                throw new RuntimeException(e);
            }
        }
    }

    public void UserDelete(int id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            try {
                session.beginTransaction();
                session.remove(session.get(User.class, id));
                session.getTransaction().commit();
            } catch (HibernateException e) {
                session.getTransaction().rollback();
                throw new RuntimeException(e);
            }
        }
    }
}
