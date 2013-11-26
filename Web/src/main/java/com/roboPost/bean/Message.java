package com.roboPost.bean;

import com.roboPost.svc.MessageServices;
import com.roboPost.svc.UserServices;

import java.util.Date;

/**
 * User: evidal
 * Date: 19/11/13
 * Time: 18:42
 */
public class Message {
    User from;
    User to;
    String Message;
    boolean delivered;
    Date datePosted;
    Date dateDelivered;

    public Message(String from, String to, String message) {
        UserServices s = new UserServices();
        this.from = s.getUserByName(from);
        this.to = s.getUserByName(to);
        Message = message;
        datePosted = new Date();
    }

    public User getFrom() {
        return from;
    }

    public void setFrom(User from) {
        this.from = from;
    }

    public User getTo() {
        return to;
    }

    public void setTo(User to) {
        this.to = to;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public boolean isDelivered() {
        return delivered;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }

    public Date getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(Date datePosted) {
        this.datePosted = datePosted;
    }

    public Date getDateDelivered() {
        return dateDelivered;
    }

    public void setDateDelivered(Date dateDelivered) {
        this.dateDelivered = dateDelivered;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message = (Message) o;

        if (delivered != message.delivered) return false;
        if (!Message.equals(message.Message)) return false;
        if (dateDelivered != null ? !dateDelivered.equals(message.dateDelivered) : message.dateDelivered != null)
            return false;
        if (!datePosted.equals(message.datePosted)) return false;
        if (!from.equals(message.from)) return false;
        if (!to.equals(message.to)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = from.hashCode();
        result = 31 * result + to.hashCode();
        result = 31 * result + Message.hashCode();
        result = 31 * result + (delivered ? 1 : 0);
        result = 31 * result + datePosted.hashCode();
        result = 31 * result + (dateDelivered != null ? dateDelivered.hashCode() : 0);
        return result;
    }
}
