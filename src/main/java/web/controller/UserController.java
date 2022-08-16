package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import web.dao.UserDao;
import web.dao.UserDaoImpl;

@Controller
public class UserController {

//    @Autowired
//    UserDao userDAO;
//
//    @GetMapping("/")
//    public String printAllUsers(ModelMap model) {
//        UserDao userDao=new UserDaoImpl();
////        model.addAttribute("users", userDAO.getAllUsers());
////        return "usersAll";
//        return "index";
//    }
//
//    @GetMapping("/{id}")
//    public String printUserById(ModelMap model, @PathVariable("id") int id) {
//        model.addAttribute("user", userDAO.getUserById(id));
//        return "user";
//    }
//
//    @PostMapping("/new")
//    public String createNewUser(@ModelAttribute("user") @Valid User user,BindingResult bindingResult) {
//        if(bindingResult.hasErrors()){return "redirect:/";}
//        userDAO.addNewUser(user);
//        return "redirect:/";
//    }
//
//    @PatchMapping("/{id}")
//    public String updateUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult,
//                             @PathVariable("id") int id) {
//        if(bindingResult.hasErrors()){return "redirect:/{id}";}
//        userDAO.updateUser(user, id);
//        return "redirect:/";
//    }
//
//    @DeleteMapping("/{id}")
//    public String deleteUser(@PathVariable("id") int id) {
//        userDAO.UserDelete(id);
//        return "redirect:/";
//    }
}
