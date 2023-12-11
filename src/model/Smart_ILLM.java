/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import io.github.amithkoujalgi.ollama4j.core.OllamaAPI;
import io.github.amithkoujalgi.ollama4j.core.exceptions.OllamaBaseException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Izan Jiménez Chaves
 */
public class Smart_ILLM implements ILLM {
    String identifier = "Smart_ILLM";
    String host = "http://localhost:11434/";
    OllamaAPI ollamaAPI = new OllamaAPI(host);
    
    @Override
    public String speak(String string) {
        String response;
        try {
            response = ollamaAPI.ask("mistral", string);
            return response;
        } catch (OllamaBaseException ex) {
            Logger.getLogger(Smart_ILLM.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Smart_ILLM.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Smart_ILLM.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public String getIdentifier() {
        return identifier;
    }
    
}
