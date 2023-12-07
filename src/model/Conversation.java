/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Izan Jimènez Chaves
 */
public class Conversation implements Serializable {
    String llmName;
    ArrayList<Message> mensajes;

    public Conversation(String llmName, ArrayList<Message> mensajes) {
        this.llmName = llmName;
        this.mensajes = mensajes;
    }

    public String getLlmName() {
        return llmName;
    }

    public void setLlmName(String llmName) {
        this.llmName = llmName;
    }

    public ArrayList<Message> getMensajes() {
        return mensajes;
    }

    public void setMensajes(ArrayList<Message> mensajes) {
        this.mensajes = mensajes;
    }
    
    public void newMessage(Message message) {
        mensajes.add(message);
    }
    
}
