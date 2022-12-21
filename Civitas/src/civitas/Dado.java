package src.civitas;

import java.util.Random;
/**
 *
 * @author antonio
 */
public class Dado {
    private Random random = new Random();
    private int ultimoResultado;
    private boolean debug;
    static final private Dado instance = new Dado();

    private Dado() {
        ultimoResultado = -1; // Dejamos el -1, aún así creo que este dato se refiere a una tirada del dado
        // Luego 0 tampoco sería una posible tirada, serán de 1 a 6.
        debug = false;
    }

    static public Dado getInstance() {
        return instance;
    }
    
    public int tirar() {
        if (debug)
            ultimoResultado = 1;
        else
            ultimoResultado = random.nextInt(6-1+1) + 1;
        return ultimoResultado;            
    }
    
    int quienEmpieza(int n) {
        return random.nextInt((n-1)-0+1) + 0;
    }

    public void setDebug(boolean d) {
        debug = d;
    }

    public int getUltimoResultado() {
        return ultimoResultado;
    }

}
