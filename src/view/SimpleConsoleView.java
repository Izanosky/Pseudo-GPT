/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
import static com.coti.tools.Esdia.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import model.Conversation;
import model.Message;
/**
 *
 * @author Izan Jimènez Chaves
 */
public class SimpleConsoleView extends ApplicationView {
    
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/mm/yyyy : HH:mm:ss");
    
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
            opcion = readInt("Ingrese una opcion: ");

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
                    System.out.println("Opcion no valida.");
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
            opcion = readInt("Ingrese una opcion: ");

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
                    System.out.println("Opcion no valida.");
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
            opcion = readInt("Ingrese una opcion: ");

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
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 3);
    }
    
    public void newConversation () {
        c.newMessages();
        Instant start = Instant.now().truncatedTo(ChronoUnit.SECONDS);
        String temp;
        String response;
        System.out.println("-------------- NUEVA CONVERSACION --------------");
        while (true) {
            System.out.printf("Yo [" + start + "]");
            temp = readString_ne(": ");
            System.out.println("");
            
            if (temp.equals("/salir")) {
                break;
            }
            else {
                Instant msg1 = Instant.now().truncatedTo(ChronoUnit.SECONDS);
                c.addMessage(new Message("Usuario", temp, msg1.getEpochSecond()));
            }
            
            response  = c.getResponse(temp);
            Instant msg2 = Instant.now().truncatedTo(ChronoUnit.SECONDS);
            c.addMessage(new Message("Agent", response, msg2.getEpochSecond()));
            System.out.printf("Agent [" + msg2 + "]: " + response + "\n");
            System.out.println("");
            
        }
        Instant end = Instant.now().truncatedTo(ChronoUnit.SECONDS);
        c.setConversation(start.getEpochSecond(), end.getEpochSecond());
        System.out.println("Conversacion finalizada. Volviendo al Menu Principal");
    }
    
    public void listarConversaciones () {
        ArrayList<Conversation> conversaciones = c.getConversation();
        int indice = 1;
        int opcion;       
        if(!conversaciones.isEmpty()) {
            System.out.println(Conversation.getHeader());
            for (Conversation conver : conversaciones) {
                System.out.printf("%10d" + conver.getTable() + "\n", indice++);
            }
            do {
                System.out.println("");
                System.out.println("1. Ver conversacion completa");
                System.out.println("2. Volver");
                opcion = readInt("Ingrese una opcion: ");

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
                        LocalDateTime inicioConver = LocalDateTime.ofEpochSecond(conver.getFechaInicio(), 0, ZoneOffset.ofHours(1));       
                        
                        System.out.println("Conversacion del dia: " + inicioConver.format(formato));
                        for (Message m : conver.getMensajes()) {
                            LocalDateTime mensaje = LocalDateTime.ofEpochSecond(m.getEpochSeconds(), 0, ZoneOffset.ofHours(1));
                            System.out.println(String.format("%10s [%s]: %s", m.getSender(), mensaje.format(formato), m.getContent()));
                        }
                        break;
                    case 2:
                        System.out.println("Volviendo...");
                        break;
                    default:
                        System.out.println("Opcion no valida.");
                }
            } while (opcion != 2);
        }
        else {
            System.out.println("------- NO HAY CONVERSACIONES DISPONIBLES -------");
        }   
    }
    
    public void eliminarConversaciones () {
        int selected;
        ArrayList<Conversation> conversaciones = c.getConversation();
        if(!conversaciones.isEmpty()){
            do{
                selected = readInt("Indique el indice de la conversacion que desea eliminar: ");
                if(selected <= 0 || selected > c.getConversationSize()){
                    System.out.println("----- INDICE NO VALIDO -----");
                }
            }while(selected <= 0 || selected > c.getConversationSize());
        
            c.eliminarConversacion(selected-1);
            conversaciones = c.getConversation();
            int indice = 1;
            System.out.println("\nConversaciones actualizadas: ");
            if (!conversaciones.isEmpty()) {
                System.out.println(Conversation.getHeader());
                for (Conversation conver : conversaciones) {
                    System.out.printf("%10d" + conver.getTable() + "\n", indice++);
                }
            }            
            else{
                System.out.println("------- NO HAY CONVERSACIONES DISPONIBLES -------");
            }
        }
        else {
            System.out.println("NO HAY CONVERSACIONES DISPONIBLES");
        }
        
        
    }
    
    public void importarConversaciones () {
        if(c.importConversations()){
            System.out.println("\n----- CONVERSACIONES IMPORTADAS CON EXITO");
        }
        else{
            System.out.println("\n----- NO SE PUDO IMPORTAR LAS CONVERSACIONES");
        }
    }
    
    public void exportarConversaciones () {
        if(c.exportConversations()){
            System.out.println("\n----- CONVERSACIONES EXPORTADAS CON EXITO");
        }
        else{
            System.out.println("\n----- NO SE PUDO EXPORTAR LAS CONVERSACIONES");
        }
    }
    
}
