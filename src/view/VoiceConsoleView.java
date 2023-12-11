/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import static com.coti.tools.Esdia.readInt;
import static com.coti.tools.Esdia.readString_ne;
import io.github.jonelo.jAdapterForNativeTTS.engines.SpeechEngine;
import io.github.jonelo.jAdapterForNativeTTS.engines.SpeechEngineNative;
import io.github.jonelo.jAdapterForNativeTTS.engines.Voice;
import io.github.jonelo.jAdapterForNativeTTS.engines.exceptions.SpeechEngineCreationException;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import model.Conversation;
import model.Message;

/**
 *
 * @author Izan Jimènez Chaves
 */
public class VoiceConsoleView extends ApplicationView {
    SpeechEngine speechEngine;
    List<Voice> voices;
    Voice voice;
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/mm/yyyy : HH:mm:ss");
            
    public VoiceConsoleView () {
        try {
            speechEngine = SpeechEngineNative.getInstance();
            voices = speechEngine.getAvailableVoices();

            voice = voices.get(0);      
            speechEngine.setVoice(voice.getName());
    
        }    
        catch(SpeechEngineCreationException e) {
            System.err.println(e.getMessage());
            speechEngine = null;
            voice = null;
        }
    }
     
    @Override
    public void showApplicationStart(String welcomeMsg) {
        System.out.printf(welcomeMsg + "\n");
    }

    @Override
    public void showMainMenu() {
        int opcion;      
        do {
            try{
                String str = 
                             "Menu principal." +
                             "1 Nueva Conversacion." +
                             "2 Menu Conversaciones." +
                             "3 Menu exportacion." +
                             "4 Salir." +
                             "Ingrese una opcion ";
                speechEngine.say(str);            
            }catch(IOException e) {
                System.err.println("ERROR: " + e.getMessage());
            }
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1. Nueva Conversacion");
            System.out.println("2. Menu Conversaciones");
            System.out.println("3. Menu exportacion");
            System.out.println("4. Salir");
            opcion = readInt("Ingrese una opcion: ");

            switch (opcion) {
                case 1:
                    speechEngine.stopTalking();
                    try{
                        speechEngine.say("Opcion elegida. Nueva Conversacion");
                    }catch(IOException e){}  
                    newConversation();
                    break;
                case 2:
                    speechEngine.stopTalking();
                    try{
                        speechEngine.say("Opcion elegida. Menu conversaciones");
                    }catch(IOException e){}
                    conversationCRUD();
                    break;
                case 3:
                    speechEngine.stopTalking();
                    try{
                        speechEngine.say("Opcion elegida. Menu exportacion");
                    }catch(IOException e){}
                    importCRUD();
                    break;
                case 4:
                    speechEngine.stopTalking();
                    try{
                        speechEngine.say("Saliendo");
                    }catch(IOException e){}                    
                    System.out.println("Saliendo...");
                    try{ 
                        Thread.sleep(1000); 
                    } catch(Exception e ) {  }
                    break;
                default:
                    speechEngine.stopTalking();
                    try{
                        speechEngine.say("Opcion no valida");
                    }catch(IOException e){} 
                    System.out.println("Opcion no valida.");
                    try{ 
                        Thread.sleep(1000); 
                    } catch(Exception e ) {  }
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
            speechEngine.stopTalking();
            String str = 
                "Menu Conversaciones." +
                "1 Listar conversaciones." +
                "2 Eliminar conversacion." +
                "3 Salir." +
                "Ingrese una opcion ";
            try {   
                speechEngine.say(str);
            } catch (IOException ex) {}
            System.out.println("\n--- MENU CONVERSACIONES ---");
            System.out.println("1. Listar Conversaciones");
            System.out.println("2. Eliminar Conversacion");
            System.out.println("3. Salir");
            opcion = readInt("Ingrese una opcion: ");

            switch (opcion) {
                case 1:
                    speechEngine.stopTalking();
                    try{
                        speechEngine.say("Opcion elegida. Listar conversaciones");
                    }catch(IOException e){}
                    listarConversaciones();
                    break;
                case 2:
                    speechEngine.stopTalking();
                    try{
                        speechEngine.say("Opcion elegida. Eliminar conversacion");
                    }catch(IOException e){}
                    eliminarConversaciones();
                    break;
                case 3:
                    speechEngine.stopTalking();
                    try{
                        speechEngine.say("Volviendo");
                    }catch(IOException e){}                    
                    System.out.println("Volviendo...");
                    try{ 
                        Thread.sleep(1000); 
                    } catch(Exception e ) {  }
                    break;
                default:
                    speechEngine.stopTalking();
                    try{
                        speechEngine.say("Opcion no valida");
                    }catch(IOException e){} 
                    System.out.println("Opcion no valida.");
                    try{ 
                        Thread.sleep(1000); 
                    } catch(Exception e ) {  }
            }
        } while (opcion != 3);
    }
    
    public void importCRUD () {
        int opcion;
        
        do {
            speechEngine.stopTalking();
            String str = 
                "MENU IMPORTACION." +
                "1 Importar Conversaciones." +
                "2 Exportar Conversacion." +
                "3 Salir." +
                "Ingrese una opcion ";
            try {   
                speechEngine.say(str);
            } catch (IOException ex) {}
            System.out.println("\n--- MENU IMPORTACION ---");
            System.out.println("1. Importar Conversaciones");
            System.out.println("2. Exportar Conversaciones");
            System.out.println("3. Salir");
            opcion = readInt("Ingrese una opcion: ");

            switch (opcion) {
                case 1:
                    speechEngine.stopTalking();
                    try{
                        speechEngine.say("Opcion elegida. Importar conversaciones");
                    }catch(IOException e){}
                    importarConversaciones();
                    break;
                case 2:
                    speechEngine.stopTalking();
                    try{
                        speechEngine.say("Opcion elegida. Exportar conversaciones");
                    }catch(IOException e){}
                    exportarConversaciones();
                    break;
                case 3:
                    speechEngine.stopTalking();
                    try{
                        speechEngine.say("Volviendo");
                    }catch(IOException e){}                    
                    System.out.println("Volviendo...");
                    try{ 
                        Thread.sleep(1000); 
                    } catch(Exception e ) {  }
                    break;
                default:
                    speechEngine.stopTalking();
                    try{
                        speechEngine.say("Opcion no valida");
                    }catch(IOException e){} 
                    System.out.println("Opcion no valida.");
                    try{ 
                        Thread.sleep(1000); 
                    } catch(Exception e ) {  }
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
        System.out.println(Conversation.getHeader());
        if(!conversaciones.isEmpty()) {
            for (Conversation conver : conversaciones) {
                System.out.printf("%10d" + conver.getTable() + "\n", indice++);
            }
            do {
                speechEngine.stopTalking();
                try{
                    speechEngine.say("1 Ver conversacion completa.  2 Volver.  Ingrese una opcion");
                }catch(IOException e){}               
                System.out.println("");
                System.out.println("1. Ver conversacion completa");
                System.out.println("2. Volver");
                opcion = readInt("Ingrese una opcion: ");

                switch (opcion) {
                    case 1:
                        speechEngine.stopTalking();
                        try{
                            speechEngine.say("Opcion elegida. Ver conversacion completa");
                        }catch(IOException e){}
                        int selected;                   
                        do{     
                            selected = readInt("Indique el indice de la conversacion que desea leer: ");
                            if(selected < 0 || selected > c.getConversationSize()){ 
                                System.out.println("----- INDICE NO VALIDO -----");
                                try{ 
                                    Thread.sleep(1000); 
                                } catch(Exception e ) {  }
                            }
                        }while(selected < 0 || selected > c.getConversationSize());
                    
                        Conversation conver = conversaciones.get(selected-1);
                        LocalDateTime inicioConver = LocalDateTime.ofEpochSecond(conver.getFechaInicio(), 0, ZoneOffset.ofHours(1)); 
                        
                        System.out.println("Conversacion del dia: " + inicioConver.format(formato));
                        for (Message m : conver.getMensajes()) {
                            LocalDateTime mensaje = LocalDateTime.ofEpochSecond(m.getEpochSeconds(), 0, ZoneOffset.ofHours(1));
                            System.out.println(String.format("%10s [%s]: %s", m.getSender(), mensaje.format(formato), m.getContent()));
                        }
                        try{ 
                            Thread.sleep(2000); 
                        } catch(Exception e ) {  }
                        break;
                    case 2:
                        speechEngine.stopTalking();
                        try{
                            speechEngine.say("Volviendo");
                        }catch(IOException e){}                    
                        System.out.println("Volviendo...");
                        try{ 
                            Thread.sleep(1000); 
                        } catch(Exception e ) {  }
                        break;
                    default:
                        speechEngine.stopTalking();
                        try{
                            speechEngine.say("Opcion no valida");
                        }catch(IOException e){} 
                        System.out.println("Opcion no valida.");
                        try{ 
                            Thread.sleep(1000); 
                        } catch(Exception e ) {  }
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
        
            c.eliminarConversacion(selected);        
            int indice = 1;
            System.out.println("\nConversaciones actualizadas");
            System.out.println(Conversation.getHeader());
            for (Conversation conver : conversaciones) {
                System.out.printf("%10d" + conver.getTable() + "\n", indice++);
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
