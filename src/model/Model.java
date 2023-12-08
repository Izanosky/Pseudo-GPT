/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 *
 * @author Izan Jiménez Chaves
 */
public class Model {
    IRepository rep;
    ILLM intel;
    File ficheroSerializado;
    ArrayList<Conversation> conversaciones;
    ArrayList<Message> mensajes;
    
    public Model(IRepository r, ILLM i) {
        this.intel = i;
        this.rep = r;
        ficheroSerializado = Paths.get(System.getProperty("user.home"), "Desktop","jLLM", "jLLM.bin").toFile();
        conversaciones = new ArrayList<>();
    }
    
    public int getConversationsSize() {
        return conversaciones.size();
    }
    
    public void newMessages() {
        mensajes = new ArrayList<>();
    }
    
    public void addMessage(Message msg) {
        mensajes.add(msg);
    }
    
    public void setConversation(String start, String end, long strt, long End){ 
        conversaciones.add(new Conversation(intel.getIdentifier(), mensajes, start, end, strt, End));
    }
    
    public ArrayList<Conversation> getConversation() {
        ArrayList <Conversation> copy = new ArrayList<>(conversaciones.size());
        
        for (Conversation c : conversaciones) {
            copy.add(c);
        }     
        return copy;
    }
    
    public String getResponse(String t) {
        return intel.speak(t);
    }
    
    public void eliminarConversacion(int indice) {
            conversaciones.remove(indice);
    }
    
    public boolean importConversations() {
        conversaciones = rep.importConversation();
        if (conversaciones != null) {
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean exportConversations() {
        rep.exportConversation(conversaciones);
        return rep.getStatus();
    }
    
    public boolean cargarEstado() {
        if (ficheroSerializado.exists() && ficheroSerializado.isFile()) {
            ObjectInputStream ois = null;
            try {
                ois = new ObjectInputStream(new FileInputStream(ficheroSerializado));
                this.conversaciones = (ArrayList<Conversation>) ois.readObject();
            } catch (IOException | ClassNotFoundException ex) {
                System.err.println("Error durante la deserialización: " + ex.getMessage());
                return false;
            } finally {
                if (ois != null) {
                    try {
                        ois.close();
                    } catch (IOException ex) {
                        System.err.println("Error durante la deserialización: " + ex.getMessage());
                        return false;
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }
    
    public boolean guardarEstadoAplicación() {

        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(ficheroSerializado));
            oos.writeObject(conversaciones);
            return true;
        } catch (IOException ex) {
            System.err.println("Error durante la serialización: " + ex.getMessage());
            return false;
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException ex) {
                    System.err.println("Error al cerrar el flujo: " + ex.getMessage());
                    return false;
                }
            }
        }

    }
}
