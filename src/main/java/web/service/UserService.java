package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(long id);

    void addNewUser(User user);

    void updateUser(User user, long id);

    void UserDelete(long id);
}
