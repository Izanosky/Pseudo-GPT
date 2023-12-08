/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
import static com.coti.tools.Esdia.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import model.Conversation;
import model.Message;
/**
 *
 * @author Izan Jimènez Chaves
 */
public class SimpleConsoleView extends ApplicationView {
    
    LocalDateTime dateTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy : HH:mm:ss");
    
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
        String start = dateTime.format(formatter);
        ArrayList<Message> msg = new ArrayList<>();
        String temp;
        String response;
        System.out.println("-------------- NUEVA CONVERSACION --------------");
        while (true) {
            System.out.printf("Yo [" + dateTime.format(formatter) + "]");
            temp = readString_ne(": ");
            System.out.println("");
            
            if (temp.equals("/salir")) {
                break;
            }
            else {
                msg.add(new Message("Usuario", temp, dateTime.format(formatter)));
            }
            
            response  = c.getResponse(temp);
            msg.add(new Message("Agent", response, dateTime.format(formatter)));
            System.out.printf("Agent [" + dateTime.format(formatter) + "]: " + response + "\n");
            
        }
        String end = dateTime.format(formatter);
        c.setConversation(msg, start, end);
        System.out.println("Conversacion finalizada. Volviendo al Menu Principal");
    }
    
    public void listarConversaciones () {
        ArrayList<Conversation> conversaciones = c.getConversation();
        int indice = 1;
        int opcion;
        System.out.println(Conversation.getHeader());
        for (Conversation conver : conversaciones) {
            System.out.printf("%10d" + conver.getTable() + "\n", indice++);
        }
        
        do {
            System.out.println("");
            System.out.println("1. Ver conversacion completa");
            System.out.println("2. Volver");
            opcion = readInt("Ingrese una opción: ");

            switch (opcion) {
                case 1:
                    int selected;
                    
                    do{
                        selected = readInt("Indique el indice de la conversacion que desea leer: ");
                        if(selected < 0 || selected > c.getConversationSize()){
                            System.out.println("----- INDICE NO VALIDO -----");
                        }
                    }while(selected < 0 || selected > c.getConversationSize());
                    
                    Conversation conver = conversaciones.get(selected-1);
                    System.out.println("Conversacion del dia: " + conver.getFechaInicio());
                    for (Message m : conver.getMensajes()) {
                        System.out.println(String.format("%10s [%s]: %s", m.getSender(), m.getEpochSeconds(), m.getContent()));
                    }
                    break;
                case 2:
                    System.out.println("Volviendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 2);
    }
    
    public void eliminarConversaciones () {
        int selected;
                    
        do{
            selected = readInt("Indique el indice de la conversacion que desea eliminar: ");
            if(selected < 0 || selected > c.getConversationSize()){
                System.out.println("----- INDICE NO VALIDO -----");
            }
        }while(selected < 0 || selected > c.getConversationSize());
        
        if(c.eliminarConversacion(selected)) {
            System.out.println("Conversacion eliminada con exito");
        }
        else{
            System.out.println("No se pudo eliminar la conversacion");
        }
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
