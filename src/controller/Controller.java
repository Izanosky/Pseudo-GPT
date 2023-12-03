/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import view.ApplicationView;
import model.Model;

/**
 *
 * @author Izan Jimènez Chaves
 */
public class Controller {
    Model m;
    ApplicationView v;
    
    public Controller(Model mod, ApplicationView vi){
        this.m = mod;
        this.v = vi;
        v.setController(this);
    }
}
