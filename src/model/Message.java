/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Izan Jimènez Chaves
 */
public class Message implements Serializable {
    String sender;
    String epochSeconds;
    String content;

    public Message(String sender, String content, String date) {
        this.sender = sender;
        this.content = content;
        this.epochSeconds = date;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getEpochSeconds() {
        return epochSeconds;
    }

    public void setEpochSeconds(String epochSeconds) {
        this.epochSeconds = epochSeconds;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
}
