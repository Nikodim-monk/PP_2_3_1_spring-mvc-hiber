package web.dao;


import web.model.User;

import java.util.List;

public interface UserDao{

    List<User> getAllUsers();

    User getUserById(long id);

    void addNewUser(User user);

    void updateUser(User user, long id);

    void UserDelete(long id);
}
