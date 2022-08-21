package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.dao.UserDao;
import web.model.User;


@Controller
public class UserController {
    @Autowired
    private UserDao userDao;

    @GetMapping("/")
    public String printAllUsers(ModelMap model) {
        model.addAttribute("users", userDao.getAllUsers());
        return "usersAll";
    }

    @GetMapping("/{id}")
    public String printUserById(ModelMap model, @PathVariable("id") long id) {
        model.addAttribute("user", userDao.getUserById(id));
        return "user";
    }

    @PostMapping("/new")
    public String createNewUser(@ModelAttribute("user") User user) {
        userDao.addNewUser(user);
        return "redirect:/";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user,@PathVariable("id") long id) {
        userDao.updateUser(user, id);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userDao.UserDelete(id);
        return "redirect:/";
    }
}
