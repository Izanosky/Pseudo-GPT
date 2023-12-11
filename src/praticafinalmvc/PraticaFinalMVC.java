/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package praticafinalmvc;

import view.ApplicationView;
import view.SimpleConsoleView;
import view.VoiceConsoleView;

import controller.Controller;

import model.Model;
import model.ILLM;
import model.IRepository;
import model.CSV_ILLM;
import model.Fake_ILLM;
import model.XML_Repository;
import model.JSON_Repository;
import model.Smart_ILLM;

/**
 *
 * @author Izan Jimènez Chaves
 */
public class PraticaFinalMVC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ApplicationView v;
        IRepository r;
        ILLM l;
        
        if(args.length == 3){
            r = setIRepository(args[0]);
            l = setILLM(args[1]);
            v = setApplicationView(args[2]);
        }else{
            // Opciones por defecto:
            r = new JSON_Repository();
            l = new Fake_ILLM();
            v = new SimpleConsoleView();
        }
        
        Model m = new Model(r, l);
        Controller c = new Controller(m, v);
        
        c.initApplication();
    }
    
    private static IRepository setIRepository(String arg) {
        switch (arg) {
            case "xml":
                return new XML_Repository();
            case "json":
                return new JSON_Repository();
            default:
                return new JSON_Repository();
        }
    }
    
    private static ILLM setILLM(String arg) {
        switch (arg) {
            case "csv":
                return new CSV_ILLM();
            case "fake":
                return new Fake_ILLM();
            case "smart":
                return new Smart_ILLM();
            default:
                return new Fake_ILLM();
        }
    }
    
    private static ApplicationView setApplicationView(String arg) {
        switch (arg) {
            case "voz":
                return new VoiceConsoleView();
            case "consola":
                return new SimpleConsoleView();
            default:
                return new SimpleConsoleView();
        }
    }
    
}
