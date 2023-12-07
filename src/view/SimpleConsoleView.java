/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
import static com.coti.tools.Esdia.*;
import java.util.ArrayList;
import model.Message;
/**
 *
 * @author Izan Jimènez Chaves
 */
public class SimpleConsoleView extends ApplicationView {

    @Override
    public void showApplicationStart(String welcomeMsg) {
        System.out.printf(welcomeMsg + "\n");
    }

    @Override
    public void showMainMenu() {
        int opcion;
        
        do {
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1. Nueva Conversacion");
            System.out.println("2. Menu Conversaciones");
            System.out.println("3. Menu exportacion");
            System.out.println("4. Salir");
            opcion = readInt("Ingrese una opción: ");

            switch (opcion) {
                case 1:
                    newConversation();
                    break;
                case 2:
                    conversationCRUD();
                    break;
                case 3:
                    importCRUD();
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 4);
    }

    @Override
    public void showApplicationEnd(String endMsg) {
        System.out.printf(endMsg + "\n");
    } 
    
    public void conversationCRUD () {
        int opcion;
        
        do {
            System.out.println("\n--- MENU CONVERSACIONES ---");
            System.out.println("1. Listar Conversaciones");
            System.out.println("2. Eliminar Conversacion");
            System.out.println("3. Salir");
            opcion = readInt("Ingrese una opción: ");

            switch (opcion) {
                case 1:
                    listarConversaciones();
                    break;
                case 2:
                    eliminarConversaciones();
                    break;
                case 3:
                    System.out.println("Volviendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 3);
    }
    
    public void importCRUD () {
        int opcion;
        
        do {
            System.out.println("\n--- MENU IMPORTACION ---");
            System.out.println("1. Importar Conversaciones");
            System.out.println("2. Exportar Conversacion");
            System.out.println("3. Salir");
            opcion = readInt("Ingrese una opción: ");

            switch (opcion) {
                case 1:
                    importarConversaciones();
                    break;
                case 2:
                    exportarConversaciones();
                    break;
                case 3:
                    System.out.println("Volviendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 3);
    }
    
    public void newConversation () {
        ArrayList<Message> mensajes = new ArrayList<>();
        String temp;
        String response;
        System.out.println("-------------- NUEVA CONVERSACION --------------");
        while (true) {
            temp = readString_ne("Introduzca un mensaje: ");
            
            if (temp.equals("/salir")) {
                break;
            }
            else {
                mensajes.add(new Message(temp));
            }
            
            response  = c.getResponse(temp);
            mensajes.add(new Message(response));
            System.out.println("Rspuestas: " + response);
            
        }
        c.setConversation(mensajes);
        System.out.println("Conversacion finalizada");
    }
    
    public void listarConversaciones () {
        
    }
    
    public void eliminarConversaciones () {
        
    }
    
    public void importarConversaciones () {
        if(c.importConversations()){
            System.out.println("Conversaciones importadas con exito");
        }
        else{
            System.out.println("No se pudo importar las conversaciones");
        }
    }
    
    public void exportarConversaciones () {
        if(c.exportConversations()){
            System.out.println("Conversaciones exportadas con exito");
        }
        else{
            System.out.println("No se pudo exportar las conversaciones");
        }
    }
    
}
