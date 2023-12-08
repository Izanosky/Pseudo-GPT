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
    String fechaInicio;
    String fechaFin;
    long fchInicio;
    long fchFin;

    public Conversation(String llmName, ArrayList<Message> mensajes, String init, String end, long ini, long fn) {
        this.llmName = llmName;
        this.mensajes = mensajes;
        this.fechaInicio = init;
        this.fechaFin = end;
        this.fchFin = fn;
        this.fchInicio = ini;
    }
    
    public Conversation(Conversation c) {
        this.llmName = c.llmName;
        this.mensajes = c.mensajes;
        this.fechaInicio = c.fechaInicio;
        this.fechaFin = c.fechaFin;
    }

    public long getFchInicio() {
        return fchInicio;
    }

    public void setFchInicio(long fchInicio) {
        this.fchInicio = fchInicio;
    }

    public long getFchFin() {
        return fchFin;
    }

    public void setFchFin(long fchFin) {
        this.fchFin = fchFin;
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

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }  
    
    public static String getHeader() {
        return String.format("%10s|%30s|%20s|%20s ... |","Indice", "Inicio Conversacion", "Numero de Mensajes", "Primer Mensaje");
    }
    
    public String getTable() {
        Message temp = this.mensajes.get(0);
        if(temp.getContent().length() > 20 ){
            return String.format("|%30s|%20s|%20s ... |", this.fechaInicio, this.mensajes.size(), temp.getContent().substring(0, 20));
        }
        else {
            return String.format("|%30s|%20s|%20s ... |", this.fechaInicio, this.mensajes.size(), temp.getContent());
        }
        
    }
    
}
