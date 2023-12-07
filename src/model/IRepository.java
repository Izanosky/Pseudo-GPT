/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Izan Jimènez Chaves
 */
public interface IRepository {
    public ArrayList<Conversation> importConversation();
    public void exportConversation (ArrayList<Conversation> conversation);
    public boolean getStatus();
}
