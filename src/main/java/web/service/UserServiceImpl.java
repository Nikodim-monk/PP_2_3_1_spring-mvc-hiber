package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public User getUserById(long id) {
        return userDao.getUserById(id);
    }

    public void addNewUser(User user) {
        userDao.addNewUser(user);
    }

    public void updateUser(User user, long id) {
        userDao.updateUser(user, id);
    }

    public void UserDelete(long id) {
        userDao.UserDelete(id);
    }
}
