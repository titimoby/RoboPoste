package com.roboPost.svc;

import com.roboPost.bean.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * User: evidal
 * Date: 19/11/13
 * Time: 18:40
 */
@Controller
public class MessageServices {

    static List<Message> messages = new ArrayList();

    @RequestMapping(value = "/messages", method = RequestMethod.GET)
    public @ResponseBody List<Message> getMessages() {
        return messages;
    }

    @RequestMapping(value = "/messagesByUser", method = RequestMethod.GET)
    public @ResponseBody List<Message> getMessagesByUser(@RequestParam String user) {
        List<Message> messagesToReturn = new ArrayList();

        for(Message m : messages) {
            if(m.getTo().getName().equalsIgnoreCase(user)) {
                messagesToReturn.add(m);
            }
        }

        return messagesToReturn;
    }

    @RequestMapping(value = "/consumeMessagesByColor", method = RequestMethod.GET)
    public List<Message> consumeMessagesByColor(String color) {
        List<Message> messagesToReturn = new ArrayList();

        for(Message m : messages) {
            if(m.getTo().getColor().equalsIgnoreCase(color)) {
                m.setDelivered(true);
                messagesToReturn.add(m);
            }
        }

        return messagesToReturn;
    }

    @RequestMapping(value = "/consumeMessagesByUser", method = RequestMethod.GET)
    public List<Message> consumeMessagesByUser(String username) {
        List<Message> messagesToReturn = new ArrayList();

        for(Message m : messages) {
            if(m.getTo().getName().equalsIgnoreCase(username)) {
                m.setDelivered(true);
                messagesToReturn.add(m);
            }
        }

        return messagesToReturn;
    }

    @RequestMapping(value = "/postMessage", method = RequestMethod.GET)
    public void postMessage(Message m) {
        messages.add(m);
    }

    @RequestMapping(value = "/deleteMessages", method = RequestMethod.GET)
    public void deleteMessage(Message m) {
        messages.remove(m);
    }
}
