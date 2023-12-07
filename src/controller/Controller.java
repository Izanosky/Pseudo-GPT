/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.util.ArrayList;
import model.Message;
import view.ApplicationView;
import model.Model;

/**
 *
 * @author Izan Jimènez Chaves
 */
public class Controller {
    Model m;
    ApplicationView v;
    
    public Controller(Model mod, ApplicationView vi){
        this.m = mod;
        this.v = vi;
        v.setController(this);
    }
    
    public void initApplication(){
        if (m.cargarEstado()) {
            v.showApplicationStart("Inicializando la aplicacion (Estado anterior cargado exitosasmente)");
        }
        else {
            v.showApplicationStart("Inicializando la aplicacion (No se pudo cargar el estado anterior)");
        }
         
        v.showMainMenu();
        
        if (m.guardarEstadoAplicación()) {
            v.showApplicationEnd("Saliendo de la aplicacion (Estado guardado correctamente)");
        } 
        else {
            v.showApplicationEnd("Saliendo de la aplicacion (No se pudo guardar el estado)");
        }
        
    }
    
    public String getResponse(String t) {
        return m.getResponse(t);
    }
    
    public void setConversation(ArrayList<Message> mensajes) {
        m.setConversation(mensajes);
    }
    
    public boolean importConversations() {
        return m.importConversations();
    }
    
    public boolean exportConversations() {
        return m.exportConversations();
    }
}
