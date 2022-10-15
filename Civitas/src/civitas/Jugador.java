
package civitas;

import java.util.ArrayList;

import javax.xml.crypto.KeySelector.Purpose;

public class Jugador implements Comparable<Jugador> {

    static private int CasasMax = 4;
    static private int CasasPorHotel = 4;
    static private int HotelesMax = 4;
    static private float PasoPorSalida = 1000;
    static private float SaldoInicial = 7500;

    private int casillaActual;
    private String nombre;
    private boolean puedeComprar;
    private float saldo;
    private ArrayList<Casilla> propiedades;

/////////////// CONSTRUCTORS.

    Jugador(String n) {
        casillaActual = 0;
        nombre = n;
        puedeComprar = false; // Comprobar este atributo como debe de ponerse
        saldo = SaldoInicial; // Ver cantidad correcta.
        propiedades = null;
    }

    protected Jugador(Jugador j) {
        casillaActual = j.getCasillaActual();
        nombre = j.getNombre();
        puedeComprar = j.getPuedeComprar();
        saldo = j.getSaldo();
        propiedades = j.getPropiedades();
    }
    
/////////////// GETTERS.

    protected String getNombre() {
        return nombre;
    }

    private static int getCasasMax() {
        return CasasMax;
    }

    static int getCasasPorHotel() {
        return CasasPorHotel;
    }
    
    private static int getHotelesMax() {
        return HotelesMax;
    }

    private static float getPremioPasoPorSalida() {
        return PasoPorSalida;
    }

    int getCasillaActual() {
        return casillaActual;
    }

    protected float getSaldo() {
        return saldo;
    }

    protected ArrayList<Casilla> getPropiedades() {
        return propiedades;
    }

/////////////// METHODS.

    public boolean getPuedeComprar() {
        return puedeComprar;
    }

    public boolean tieneAlgoQueGestionar() { // Revisar visibilidad
        return true; // Implementar... 
    }

    @Override
    public int compareTo(Jugador o) {
        // TODO Auto-generated method stub
        return 0;
    }
}