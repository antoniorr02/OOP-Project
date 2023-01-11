
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
    private boolean puedeComprar, especulador;
    private float saldo;
    private ArrayList<CasillaCalle> propiedades;

/////////////// CONSTRUCTORS.

    public Jugador(String n) {
        casillaActual = 0;
        nombre = n;
        puedeComprar = true;
        especulador = false;
        saldo = SaldoInicial;
        propiedades = new ArrayList<CasillaCalle>();
    }

    protected Jugador(Jugador j) {
        casillaActual = j.getCasillaActual();
        nombre = j.getNombre();
        puedeComprar = j.getPuedeComprar();
        saldo = j.getSaldo();
        propiedades = j.getPropiedades();
    }

    Jugador convertir() {
        JugadorEspeculador j_especulador = new JugadorEspeculador(this);
        actualizaPropiedadesPorConversion(j_especulador);
        j_especulador.setEspeculador(true); // Ahora el jugador es especulador.
        return j_especulador;
    }

    void actualizaPropiedadesPorConversion(Jugador j_esp) {
        for (int i = 0; i < propiedades.size(); i++) {
            ((CasillaCalle) propiedades.get(i)).actualizaPropietarioPorConversion(j_esp);
        }
    }
    
/////////////// GETTERS.
    public boolean getEspeculador() {
        return especulador;
    }

    public String getNombre() {
        return nombre;
    }

    int getCasasMax() {
        return CasasMax;
    }

    static int getCasasPorHotel() {
        return CasasPorHotel;
    }
    
    int getHotelesMax() {
        return HotelesMax;
    }

    private static float getPremioPasoPorSalida() {
        return PasoPorSalida;
    }

    public int getCasillaActual() {
        return casillaActual;
    }

    public float getSaldo() {
        return saldo;
    }

    public ArrayList<CasillaCalle> getPropiedades() {
        return propiedades;
    }

    boolean getPuedeComprar() {
        return puedeComprar;
    }

/////////////// METHODS.
    void setEspeculador(boolean esp) {
        especulador = esp;
    }

    boolean enBancaRota() {
        boolean bancarrota = false;
        if (saldo <= 0) {
            bancarrota = true;
        }
        return bancarrota;
    }
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
        recibe(getPremioPasoPorSalida());
        Diario.getInstance().ocurreEvento("Pasa por salida");
        return true;
    }

    private boolean puedoEdificarCasa(CasillaCalle c) {
        return puedoGastar(c.getPrecioEdificar()) && c.getNumCasas() < getCasasMax();
    }

    private boolean puedoEdificarHotel(CasillaCalle c) {
        return puedoGastar(c.getPrecioEdificar()) && c.getNumHoteles() < getHotelesMax() && c.getNumCasas() >= getCasasPorHotel();
    }

    @Override
    public int compareTo(Jugador o) {
        return -(int)(getSaldo() - o.getSaldo());
    } // Le he puesto el signo negativo, ya que si no me colocaba el primero en el ranking al jugador con menos dinero.

    boolean comprar (CasillaCalle casilla) {
        boolean result = false;
        if (puedeComprar) {
            float precio = casilla.getPrecioCompra();
            if(puedoGastar(precio)) {
                result = casilla.comprar(this);
                propiedades.add(casilla);
                Diario.getInstance().ocurreEvento("El jugador " + getNombre() + " compra la propiedad " + casilla.getNombre());
                puedeComprar = false;
            } else {
                Diario.getInstance().ocurreEvento("El jugador " + getNombre() + " no tiene saldo para comprar la propiedad " + casilla.getNombre());
            }
        }
        return result;
    }

    boolean construirCasa(int ip) {
        boolean result = false;
        if (existeLaPropiedad(ip)) {
            CasillaCalle propiedad = ((CasillaCalle) propiedades.get(ip));
            boolean puedoEdificar = puedoEdificarCasa(propiedad);
            if(puedoEdificar) {
                float precioEdificar = propiedad.getPrecioEdificar(); 
                paga(precioEdificar);
                result = propiedad.construirCasa();
                Diario.getInstance().ocurreEvento("El jugador " + getNombre() + " construye casa en la propiedad " + propiedad.getNombre());
            }
        }
        return result;
    }

    boolean construirHotel(int ip) {
        boolean result = false;
        if (existeLaPropiedad(ip)) {
            CasillaCalle propiedad = ((CasillaCalle) propiedades.get(ip));
            boolean puedoEdificarHotel = puedoEdificarHotel(propiedad);
            if(puedoEdificarHotel) {
                float precioEdificar = propiedad.getPrecioEdificar(); 
                paga(precioEdificar);
                result = propiedad.construirHotel();
                propiedad.derruirCasas(CasasPorHotel, this);
                Diario.getInstance().ocurreEvento("El jugador " + getNombre() + " construye hotel en la propiedad " + propiedad.getNombre());
            }
        }
        return result;
    }

    public String toString(){
        String cadena = "";
        cadena = "Jugador " + getNombre() + " con saldo: " + getSaldo() + " y con propiedades:\n" + getPropiedades().toString();
        return cadena;
    } 
}