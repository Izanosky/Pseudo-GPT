/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Izan Jimènez Chaves
 */
public class Model {
    IRepository rep;
    ILLM intel;
    
    public Model(IRepository r, ILLM i) {
        this.intel = i;
        this.rep = r;
    }
}
