package com.roboPost.svc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.roboPost.bean.Message;

import com.roboPost.bean.User;

import javax.servlet.http.HttpServletRequest;

/**
 * User: evidal
 * Date: 25/11/13
 * Time: 17:09
 */
@Controller
public class RoboPostController {

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@RequestParam String username, @RequestParam String color, HttpServletRequest request) {
        if(request.getSession().getAttribute("currentUser") == null) {
            UserServices s = new UserServices();
            User u = new User(username, color);
            s.addUser(u);
            request.getSession().setAttribute("currentUser", u);
        }
        return "redirect:/r/sendMessage";
    }

    @RequestMapping(value = "/sendMessage", method = {RequestMethod.GET, RequestMethod.POST})
    public void sendMessage(@RequestParam(required = false) String recipient,
                            @RequestParam(required = false) String message,
                            HttpServletRequest request) {
        if(recipient != null && message != null && recipient.length() > 0 && message.length() > 0) {
            System.out.println(recipient+":"+message);
            MessageServices s = new MessageServices();
            User from = (User) request.getSession().getAttribute("currentUser");
            Message m = new Message(from.getName(), recipient, message);
            s.postMessage(m);
        }
    }
}
