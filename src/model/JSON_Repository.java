/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class JSON_Repository implements IRepository {
    Path ruta = Paths.get(System.getProperty("user.home"), "Desktop", "jLLM", "input.json");
    
    @Override
    public List<Conversation> importConversation() {
        Gson gson = new Gson();
        try{
            String json = new String(Files.readAllBytes(ruta), StandardCharsets.UTF_8);
            Type tipoDeLista = new TypeToken<List<Conversation>>() {}.getType();
            return gson.fromJson(json, tipoDeLista);
        }catch(IOException e) {
            System.out.println("ERROR: " + e.getMessage());
            return null;
        }
    }

    @Override
    public void exportConversation(List<Conversation> conversation) {
        try {
            Gson gson = new Gson();
            String json = gson.toJson(conversation);
            Files.write(ruta, json.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            System.err.println("Error:" + e.getMessage());
        }
    }
    
}
