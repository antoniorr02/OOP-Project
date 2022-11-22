package ejercicios;

/**
 *
 * @author antonio
 */
public class Casilla {
    private String nombre;
    
    Casilla(String n) {
        nombre = n;
    }
    
    boolean recibeJugador() {
        System.out.println("Se ha recibido un jugador");
        return true;
    }
}
