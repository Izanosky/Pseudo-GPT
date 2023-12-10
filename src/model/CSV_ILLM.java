/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Usuario
 */
public class CSV_ILLM implements ILLM {
    ArrayList<Text> respuestas;
    ArrayList<Text> saludos;
    ArrayList<Text> despedidas;
    String delimitador = ",";
    Path ruta = Paths.get(System.getProperty("user.home"), "Desktop", "jLLM", "input.csv");
    String identifier = "CSV_ILLM";
    
    public CSV_ILLM () {
        respuestas = new ArrayList<>();
        saludos = new ArrayList<>();
        despedidas = new ArrayList<>();
        
        try {
            List<String> lineas = Files.readAllLines(ruta);
            for (String linea : lineas) {
                Text t = Text.getMessageFromDelimitedString(linea, delimitador);
                if (t != null) {
                    respuestas.add(t);
                }
            }
        } catch (IOException e) {
            System.err.println("ERROR " + e.getMessage());
        }
        
        for(Text t: respuestas){
            if(t.getType().equals("saludo")){
                saludos.add(t);
            }
            if(t.getType().equals("despedida")){
                despedidas.add(t);
            }
        }
    }
    
    @Override
    public String speak(String string) {
        int posicion;
        if(string.contains("Buenas") && !saludos.isEmpty() || string.contains("Hola") && !saludos.isEmpty() || string.contains("Buenos") && !saludos.isEmpty()){
            posicion  = (int) (Math.random() * saludos.size());
            Text t = saludos.get(posicion);
            return t.getContent();
        }
        else if(string.contains("Adios") && !despedidas.isEmpty() || string.contains("Chao") && !despedidas.isEmpty()){
            posicion  = (int) (Math.random() * despedidas.size());
            Text t = despedidas.get(posicion);
            return t.getContent();
        }
        posicion  = (int) (Math.random() * respuestas.size());
        Text t = respuestas.get(posicion);
        return t.getContent();
        
    }

    @Override
    public String getIdentifier() {
        return identifier;
    }
    
}
