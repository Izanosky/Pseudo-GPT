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
    private String sender;
    private long epochSeconds;
    private String content;
    
    public Message() {
        
    }
    public Message(String sender, String content, long seconds) {
        this.sender = sender;
        this.content = content;
        this.epochSeconds = seconds;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public long getEpochSeconds() {
        return epochSeconds;
    }

    public void setEpochSeconds(long epochSeconds) {
        this.epochSeconds = epochSeconds;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
}
