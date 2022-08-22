package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;


@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String printAllUsers(ModelMap model) {
        model.addAttribute("users", userService.getAllUsers());
        return "usersAll";
    }

    @GetMapping("/{id}")
    public String printUserById(ModelMap model, @PathVariable("id") long id) {
        model.addAttribute("user", userService.getUserById(id));
        return "user";
    }

    @PostMapping("/new")
    public String createNewUser(@ModelAttribute("user") User user) {
        userService.addNewUser(user);
        return "redirect:/";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user,@PathVariable("id") long id) {
        userService.updateUser(user, id);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.UserDelete(id);
        return "redirect:/";
    }
}
