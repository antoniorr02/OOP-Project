package civitas;

import java.util.ArrayList;

/**
 *
 * @author antonio
 */
public class Tablero {
    private ArrayList<Casilla> casillas;
    private boolean porSalida;
        
    Tablero(){
        casillas = null;
        porSalida = false;
    }
    
    private boolean correcto(int numCasilla) {
        return numCasilla < casillas.size();
    }
    
    boolean computarPasoPorSalida() {
        boolean inicial = porSalida;
        porSalida = false;
        return inicial;
    }
    
    void añadeCasilla(Casilla casilla) {
        casillas.add(casilla);
    }
    
    Casilla getCasilla(int numCasilla) {
        if (correcto(numCasilla))
            return casillas.get(numCasilla);
        else
            return null;
    }
    
    int nuevaPosicion(int actual, int tirada) {
        int pos = actual + tirada;
        if (pos >= casillas.size()) {
            porSalida = true;
            pos %= casillas.size();
        }
        return pos;
    }    
}
