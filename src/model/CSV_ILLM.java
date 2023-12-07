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
    ArrayList<String> respuestas;
    String delimitador = ",";
    Path ruta = Paths.get(System.getProperty("user.home"), "Desktop", "jLLM", "input.csv");
    String identifier = "CSV_ILLM";
    
    public CSV_ILLM () {
        respuestas = new ArrayList<>();
        try {
            List<String> lineas = Files.readAllLines(ruta);
            for (String linea : lineas) {
                Text t = Text.getMessageFromDelimitedString(linea, delimitador);
                if (t != null) {
                    respuestas.add(t.getContent());
                }
            }
        } catch (IOException e) {
            
        }
    }
    
    @Override
    public String speak(String string) {
        int posicion  = (int) (Math.random() * respuestas.size());
        return respuestas.get(posicion);
    }

    @Override
    public String getIdentifier() {
        return identifier;
    }
    
}
