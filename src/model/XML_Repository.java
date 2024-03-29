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
 * @author Izan Jiménez Chaves
 */
public class XML_Repository implements IRepository {
    Path rutaImp = Paths.get(System.getProperty("user.home"), "Desktop", "jLLM", "input.xml");
    Path rutaExp = Paths.get(System.getProperty("user.home"), "Desktop", "jLLM", "output.xml");
    boolean status;
    
    @Override
    public List<Conversation> importConversation() {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            String xml = new String(Files.readAllBytes(rutaImp), StandardCharsets.UTF_8);
            return xmlMapper.readValue(xml, xmlMapper.getTypeFactory().constructCollectionType(List.class, Conversation.class));
        } catch (IOException ex) {
            return null;
        }
    }

    @Override
    public void exportConversation(List<Conversation> conversation) {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            String xml = xmlMapper.writeValueAsString(conversation);
            Files.write(rutaExp, xml.getBytes(StandardCharsets.UTF_8));
            status = true;
        } catch (JsonProcessingException e) {
            status = false;
        } catch (IOException e) {
            status = false;
        }
    }

    @Override
    public boolean getStatus() {
        return status;
    }

    
    
}
