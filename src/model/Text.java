/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Izan Jiménez Chaves
 */
public class Text {
    String content;
    String length;
    String type;

    public Text(String content, String length, String type) {
        this.content = content;
        this.length = length;
        this.type = type;
    }
    
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public static Text getMessageFromDelimitedString (String delimitedString, String delimiter) {
        String chunks [] = delimitedString.split(delimiter);
        
        if (chunks.length != 3) {
            return null;
        }
        
        try {
            String contenido = chunks[2];
            String longitud = chunks[1];
            String tipo = chunks[0];
            Text t = new Text(contenido, longitud, tipo);
            return t;
        } catch (Exception e) {
            // Tomamos linea como inválida
            return null;
        }
    }  
    
}
