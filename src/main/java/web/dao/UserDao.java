package web.dao;


import web.model.User;

import java.util.List;

public interface UserDao{

    List<User> getAllUsers();

    User getUserById(int id);

    void addNewUser(User user);

    void updateUser(User user, int id);

    void UserDelete(int id);
}
