package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return entityManager.createQuery("SELECT i FROM User i", User.class).getResultList();
    }

    @Transactional(readOnly = true)
    public User getUserById(long id) {
        return entityManager.createQuery("SELECT i FROM User i WHERE i.Id = :id", User.class)
                .setParameter("id", id).getSingleResult();
    }

    @Transactional
    public void addNewUser(User user) {
        entityManager.persist(user);
    }

    @Transactional
    public void updateUser(User user, long id) {
        User userNotUpdate = entityManager.createQuery("SELECT i FROM User i WHERE i.Id = :id", User.class)
                .setParameter("id", id).getSingleResult();
        userNotUpdate.setName(user.getName());
        userNotUpdate.setAge(user.getAge());
    }

    @Transactional
    public void UserDelete(long id) {
        User user = entityManager.createQuery("SELECT i FROM User i WHERE i.Id = :id", User.class)
                .setParameter("id", id).getSingleResult();
        entityManager.remove(user);
    }
}
