/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class XML_Repository implements IRepository {
    Path ruta = Paths.get(System.getProperty("user.home"), "Desktop", "jLLM", "input.json");
    
    @Override
    public List<Conversation> importConversation() {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            String xml = new String(Files.readAllBytes(ruta), StandardCharsets.UTF_8);
            return xmlMapper.readValue(xml, xmlMapper.getTypeFactory().constructCollectionType(List.class, Conversation.class));
        } catch (IOException e) {
            System.err.println("Error:" + e.getMessage());
            return null;
        }
    }

    @Override
    public void exportConversation(List<Conversation> conversation) {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            String xml = xmlMapper.writeValueAsString(conversation);
            Files.write(ruta, xml.getBytes(StandardCharsets.UTF_8));
        } catch (JsonProcessingException e) {
            System.err.println("Error:" + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error:" + e.getMessage());
        }
    }
    
}
