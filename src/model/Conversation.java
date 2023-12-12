/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author Izan Jimènez Chaves
 */
public class Conversation implements Serializable {
    String llmName;
    ArrayList<Message> mensajes;
    long fechaInicio;
    long fechaFin;
    
    public Conversation() {
        
    }
    
    public Conversation(String llmName, ArrayList<Message> mensajes, long ini, long end) {
        this.llmName = llmName;
        this.mensajes = mensajes;
        this.fechaInicio = ini;
        this.fechaFin = end;
    }   
    
    
    
    public Conversation(Conversation c) {
        this.llmName = c.llmName;
        this.mensajes = c.mensajes;
        this.fechaInicio = c.fechaInicio;
        this.fechaFin = c.fechaFin;
    }
    
    

    public long getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(long fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public long getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(long fechaFin) {
        this.fechaFin = fechaFin;
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
    
    @JsonIgnore   
    public void newMessage(Message message) {
        mensajes.add(message);
    }  
    
    @JsonIgnore    
    public static String getHeader() {
        return String.format("%10s|%30s|%20s|%20s ... |","Indice", "Inicio Conversacion", "Numero de Mensajes", "Primer Mensaje");
    }
    
    @JsonIgnore   
    public String getTable() {
        Message temp = this.mensajes.get(0);
        LocalDateTime horaMensaje = LocalDateTime.ofEpochSecond(this.fechaInicio, 0, ZoneOffset.ofHours(1));
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/mm/yyyy | HH:mm:ss");
        
        if(temp.getContent().length() > 20 ){              
            return String.format("|%30s|%20s|%20s ... |", horaMensaje.format(formato), this.mensajes.size(), temp.getContent().substring(0, 20));
        }
        else {
            return String.format("|%30s|%20s|%20s ... |", horaMensaje.format(formato), this.mensajes.size(), temp.getContent());            
        }
        
    }
    
}
