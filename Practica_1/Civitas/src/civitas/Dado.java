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
        ultimoResultado = 0; // Comprobar si es válido
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
            ultimoResultado = random.nextInt(6-0+1) + 0; //Comprobar si sirve.
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
