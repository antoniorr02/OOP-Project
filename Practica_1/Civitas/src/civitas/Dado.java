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
        ultimoResultado = -1; // Comprobar si es válido
        debug = false;         // El 0 se puede interpretar como un número de casillas a mover, no creo que afecte pero
        instance = null;        //yo le dejaba el -1
    }

    protected Dado getInstance() { // Duda: Visibilidad de paquete == protected o public?
        return instance;
    }
    
    protected int tirar() {
        if (debug)
            ultimoResultado = 1;
        else
            ultimoResultado = (int)(Math.random()*6+1); //random.nextInt(6-0+1) + 0; //Comprobar si sirve.
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
