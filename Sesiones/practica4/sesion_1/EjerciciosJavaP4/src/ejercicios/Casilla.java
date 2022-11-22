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
        System.out.println("Y además soy una casilla calle");
        return true;
    }
}
