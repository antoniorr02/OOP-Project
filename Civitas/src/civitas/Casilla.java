package civitas;

import java.util.ArrayList;

/**
 *
 * @author antonio
 */
public class Casilla {
    private TipoCasilla tipo;
    private String nombre;
    private float precioCompra, precioEdificar, precioBaseAlquiler;
    private int numCasas, numHoteles;
    private Sorpresa sorpresa;
    private MazoSorpresa mazo;
    private ArrayList<Jugador> jugadores;

    float FACTORALQUILERCALLE = 1.0f;
    float FACTORALQUILERCASA  = 1.0f;
    float FACTORALQUILERHOTEL = 4.0f;
    
    private void init() {
        this.precioCompra = 0.0f;
        this.precioEdificar = 0.0f;
        this.precioBaseAlquiler = 0.0f;
        this.numCasas = 0;
        this.numHoteles = 0;
        this.sorpresa = null; // Cuidado con la inicializacion, no estoy seguro.
        this.mazo = null;
        this.jugadores = null;
    }

    public Casilla(String calle, float preciocompra, float precioedificar, float preciobasealquiler) {
        init();
        this.tipo = TipoCasilla.CALLE;
        this.nombre = calle;
        this.precioCompra = preciocompra;
        this.precioEdificar = precioedificar;
        this.precioBaseAlquiler = preciobasealquiler;
    }

    public Casilla(String name) {
        this.tipo = TipoCasilla.DESCANSO;
        this.nombre = name;
    }

    public Casilla(String name, MazoSorpresa m) {
        this.tipo = TipoCasilla.SORPRESA;
        this.nombre = name;
        this.mazo = m;
    }

    public TipoCasilla getTipo() {
        return tipo;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public float getPrecioCompra(){
        return precioCompra;
    }
    
    public float getPrecioEdificar(){
        return precioEdificar;
    }
    
    public int getNumCasas() {
        return numCasas;
    }
    
    public int getNumHoteles() {
        return numHoteles;
    }
    
    public float getPrecioAlquilerCompleto() {
        return precioBaseAlquiler * (FACTORALQUILERCALLE + numCasas*FACTORALQUILERCASA + numHoteles*FACTORALQUILERHOTEL);
    }
    
    public boolean construirCasa() {
        int inicio = numCasas;
        numCasas++;
        return inicio == numCasas-1; // Comprobamos si el número de casas ha aumentado en 1.
    }
    
    public boolean construirHotel() {
        int inicio = numHoteles;
        numHoteles++;
        return inicio == numHoteles-1; // Comprobamos si el número de casas ha aumentado en 1.
    }

    public String toString(){
        String cadena = nombre + ": Compra " +  precioCompra + ", Edificar " + precioEdificar + ", Alquiler base " + precioBaseAlquiler + ", Casas " + numCasas + ", Hoteles " + numHoteles;
        return cadena;
    }

    public void informe(int actual, ArrayList<Jugador> todos) {
        //Diario.getInstance().ocurreEvento("Ha caido el jugador " + actual); Arreglar
    }
}
