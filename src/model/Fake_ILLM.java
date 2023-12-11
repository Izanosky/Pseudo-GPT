/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Izan Jiménez Chaves
 */
public class Fake_ILLM implements ILLM {
    ArrayList<String> respuestas = new ArrayList<String>( Arrays.asList(
        //"Adios",   
        //"Hola",
        "Más vale tarde que nunca" ,
        "No por mucho madrugar amanece más temprano" ,
        "A caballo regalado no se le mira el diente" ,
        "El que mucho abarca poco aprieta" ,
        "En casa del herrero, cuchillo de palo" ,
        "¡Hola! ¿Cómo estás?" ,
        "Buenos días, ¡espero que tengas un gran día!" ,
        "¡Qué alegría verte!" ,
        "Hola, mucho gusto en conocerte" ,
        "Saludos cordiales a todos aquí" ,
        "Hasta luego, cuídate mucho" ,
        "Adiós, nos vemos pronto" ,
        "Que tengas un buen día, nos vemos" ,
        "Hasta la próxima, ha sido un placer" ,
        "Me voy, pero nos vemos pronto" ,
        "¿Cómo te llamas?" ,
        "¿Qué hora es?" ,
        "¿Dónde está el baño?" ,
        "¿Podrías ayudarme, por favor?" ,
        "¿Cuál es tu color favorito?" ,
        "Me llamo Juan" ,
        "Son las tres de la tarde" ,
        "El baño está a la derecha" ,
        "Claro, dime en qué puedo ayudarte" ,
        "Mi color favorito es el azul" ,
        "Estoy completamente de acuerdo" ,
        "Eso es absolutamente cierto" ,
        "Sin duda, es la mejor opción" ,
        "Definitivamente, eso es correcto" ,
        "Claro que sí, es evidente" ,
        "No estoy de acuerdo con eso" ,
        "Eso no es cierto" ,
        "De ninguna manera, eso es incorrecto" ,
        "No, eso no es lo que quiero" ,
        "No, eso no es posible" ,
        "¡No puedo creerlo!" ,
        "¡Eso es asombroso!" ,
        "¡Vaya sorpresa!" ,
        "¡Increíble, no me lo esperaba!" ,
        "¡Wow, eso es impresionante!" ,
        "¡Hola, bienvenido!" ,
        "Adios, nos vemos pronto." ,
        "El que mucho abarca, poco aprieta." ,
        "No creo que sea posible." ,
        "¿Como estuvo tu fin de semana?" ,
        "¡Increible, no lo puedo creer!" ,
        "Claro, puedes contar conmigo." ,
        "¡Oh, no esperaba verte!" ,
        "¡Buenas noches, que gusto verte!" ,
        "Hasta luego, cuidate mucho." ,
        "Mas vale tarde que nunca." ,
        "No estoy de acuerdo contigo." ,
        "¿Cual es tu pelicula favorita?" ,
        "¡Guau, eso es sorprendente!" ,
        "Estoy seguro de que lo lograras." ,
        "¡No me lo esperaba para nada!" ,
        "¡Buen dia, como has estado!" ,
        "Hasta la proxima, que te vaya bien." ,
        "En boca cerrada no entran moscas." ,
        "No me siento comodo con eso." ,
        "¿Tienes algun plan para hoy?" ,
        "¡Que maravillosa sorpresa!" ,
        "Si, estoy completamente de acuerdo." ,
        "¡Vaya sorpresa verte aqui!" ,
        "¡Buenas tardes, como te ha ido!" ,
        "Hasta la vista, que tengas un buen dia." ,
        "La paciencia es una virtud." ,
        "No estoy dispuesto a hacerlo." ,
        "¿Que opinas sobre este tema?" ,
        "¡Que emocionante noticia!" ,
        "Estoy de acuerdo contigo." ,
        "¡No sabia que vendrias!" ,
        "¡Hola, que alegria verte!" ,
        "Hasta pronto, cuidate mucho." ,
        "El que mucho abarca, poco aprieta." ,
        "Lo siento, pero no puedo." ,
        "¿Como ha sido tu dia?" ,
        "¡Dios mio, que sorpresa!" ,
        "Si, estoy de acuerdo contigo." ,
        "¡No esperaba verte aqui!" ,
        "¡Buenas tardes, como estas!" ,
        "Hasta luego, que te vaya bien." ,
        "Mas vale tarde que nunca." ,
        "No estoy dispuesto a aceptar." ,
        "¿Que piensas sobre esto?") );
    
    String identifier = "FakeILLM";
    
    @Override
    public String speak(String string) {
        int posicion;
        if(string.contains("Buenas") && !respuestas.isEmpty() || string.contains("Hola") && !respuestas.isEmpty() || string.contains("Buenos") && !respuestas.isEmpty()){
            for (String resp: respuestas) {
                if(resp.contains("Buenas") || resp.contains("Hola") || resp.contains("Buenos")) {
                    return resp;
                }
            }
        }
        else if(string.contains("Adios") && !respuestas.isEmpty() || string.contains("Chao") && !respuestas.isEmpty()){
            for (String resp: respuestas) {
                if(resp.contains("Adios") || resp.contains("Hasta")) {
                    return resp;
                }
            }
        }
        posicion  = (int) (Math.random() * respuestas.size());
        return respuestas.get(posicion);
    }

    @Override
    public String getIdentifier() {
        return identifier;
    }
    
}
