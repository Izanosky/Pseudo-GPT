/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
import controller.Controller;

/**
 *
 * @author Izan Jimènez Chaves
 */
public abstract class ApplicationView {
    protected Controller c;
    
    public void setController(Controller con){
        this.c = con;
    }
    
    public abstract void showApplicationStart(String welcomeMsg);
    public abstract void showMainMenu();
    public abstract void showApplicationEnd(String endMsg);
}
