
package civitas;

import java.util.ArrayList;
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
        puedeComprar = true;
        saldo = SaldoInicial;
        propiedades = new ArrayList<Casilla>();
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

    boolean getPuedeComprar() {
        return puedeComprar;
    }

/////////////// METHODS.

    private boolean existeLaPropiedad(int ip) {
        return (ip >= 0 && ip < propiedades.size());
    }

    boolean puedeComprarCasilla() {
        puedeComprar = true;
        return puedeComprar;
    }

    boolean paga(float cantidad) {
        return modificaSaldo(cantidad*(-1));
    }

    boolean pagaAlquiler(float cantidad) {
        return paga(cantidad);
    }

    boolean recibe(float cantidad) {
        return modificaSaldo(cantidad);
    }

    boolean modificaSaldo(float cantidad) {
        saldo += cantidad;
        return true;
    }

    boolean moverACasilla(int c) {
        casillaActual = c;
        puedeComprar = false;
        Diario.getInstance().ocurreEvento("Movimiento del jugador " + nombre + " a la casilla " + casillaActual);
        return true;
    }

    private boolean puedoGastar(float precio) {
        return saldo >= precio;
    }

    boolean tieneAlgoQueGestionar() {
        return propiedades.size() >= 1; 
    }

    boolean pasaPorSalida() {
        recibe(PasoPorSalida);
        Diario.getInstance().ocurreEvento("Pasa por salida");
        return true;
    }

    private boolean puedoEdificarCasa(Casilla c) {
        return puedoGastar(c.getPrecioEdificar()) && c.getNumCasas() < 4;
    }

    private boolean puedoEdificarHotel(Casilla c) {
        return puedoGastar(c.getPrecioEdificar()) && c.getNumHoteles() < 4 && c.getNumCasas() == 4;
    }

    @Override
    public int compareTo(Jugador o) {
        return -(int)(getSaldo() - o.getSaldo());
    } // Le he puesto el signo negativo, ya que si no me colocaba el primero en el ranking al jugador con menos dinero.
}