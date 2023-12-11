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
import java.util.ArrayList;

/**
 *
 * @author Izan Jiménez Chaves
 */
public class JSON_Repository implements IRepository {
    Path rutaImp = Paths.get(System.getProperty("user.home"), "Desktop", "jLLM", "input.json");
    Path rutaExp = Paths.get(System.getProperty("user.home"), "Desktop", "jLLM", "output.json");
    boolean status;
    
    @Override
    public ArrayList<Conversation> importConversation() {
        Gson gson = new Gson();
        try{
            String json = new String(Files.readAllBytes(rutaImp), StandardCharsets.UTF_8);
            Type tipoDeLista = new TypeToken<ArrayList<Conversation>>() {}.getType();
            return gson.fromJson(json, tipoDeLista);
        }catch(IOException e) {
            return null;
        }
    }

    @Override
    public void exportConversation(ArrayList<Conversation> conversation) {
        try {
            Gson gson = new Gson();
            String json = gson.toJson(conversation);
            Files.write(rutaExp, json.getBytes(StandardCharsets.UTF_8));
            status = true;
        } catch (IOException e) {
            status = false;
        }
    }

    @Override
    public boolean getStatus() {
        return status;
    }

    
}
