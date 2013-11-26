package com.roboPost.svc;

import java.util.ArrayList;
import java.util.List;
import com.roboPost.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * User: evidal
 * Date: 19/11/13
 * Time: 19:14
 */
@Controller
public class UserServices {

    static List<User> users = new ArrayList<User>();

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public void addUser(User u) {
        users.add(u);
    }

    @RequestMapping(value = "/userUpdate", method = RequestMethod.POST)
    public void updateUser(@RequestParam(value = "username") String name, @RequestParam(value = "color") String color) {
        User user2update = getUserByName(name);
        users.remove(user2update);
        users.add(new User(name, color));
    }

    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    public void deleteUserByName(@RequestParam(value = "username") String username) {
        users.remove(getUserByName(username));
    }

    @RequestMapping(value = "/userByColor", method = RequestMethod.GET)
    public User getUserByColor(@RequestParam(value = "color") String color) {
        for(User u : users) {
            if(u.getColor().equalsIgnoreCase(color)) {
                return u;
            }
        }
        return null;
    }

    @RequestMapping(value = "/userByName", method = RequestMethod.GET)
    public User getUserByName(@RequestParam(value = "name") String name) {
        for(User u : users) {
            if(u.getName().equalsIgnoreCase(name)) {
                return u;
            }
        }
        return null;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public @ResponseBody List<User> getUsers() {
        return users;
    }

    @RequestMapping(value = "/colors", method = RequestMethod.GET)
    public @ResponseBody List<String> getColors() {
        List l = new ArrayList<String>();
        l.add("red");
        l.add("green");
        l.add("blue");
        l.add("yellow");
        return l;
    }
}