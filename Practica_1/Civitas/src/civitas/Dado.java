package civitas;

import java.util.Random;
/**
 *
 * @author antonio
 */
public class Dado {
    private Random random = new Random();
    private int ultimoResultado;
    private boolean debug;
    private Dado instance;

    private Dado() {
        ultimoResultado = -1; // Dejamos el -1, aún así creo que este dato se refiere a una tirada del dado
        // Luego 0 tampoco sería una posible tirada, serán de 1 a 6.
        debug = false;
        instance = null;
    }

    protected Dado getInstance() { // Duda: Visibilidad de paquete == protected o public?
        return instance;
    }
    
    protected int tirar() {
        if (debug)
            ultimoResultado = 1;
        else
            ultimoResultado = random.nextInt(6-1+1) + 1; //Comprobar si sirve. (Corregido antes iba de 0 a 6, ahora de 1 a 6)
        return ultimoResultado;            
    }
    
    protected int quienEmpieza(int n) {
        return random.nextInt((n-1)-0+1) + 0;
    }

    protected void setDebug(boolean d) {
        debug = d;
    }

    protected int getUltimoResultado() {
        return ultimoResultado;
    }

}
