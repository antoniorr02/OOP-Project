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
    private Jugador propietario;

    float FACTORALQUILERCALLE = 1.0f;
    float FACTORALQUILERCASA  = 1.0f;
    float FACTORALQUILERHOTEL = 4.0f;

/////////////////// CONSTRUCTORS.
    
    private void init() {
        this.precioCompra = 0.0f;
        this.precioEdificar = 0.0f;
        this.precioBaseAlquiler = 0.0f;
        this.numCasas = 0;
        this.numHoteles = 0;
        this.sorpresa = null;
        this.mazo = null;
        this.propietario = null;
    }

    Casilla(String calle, float preciocompra, float precioedificar, float preciobasealquiler) {
        init();
        this.tipo = TipoCasilla.CALLE;
        this.nombre = calle;
        this.precioCompra = preciocompra;
        this.precioEdificar = precioedificar;
        this.precioBaseAlquiler = preciobasealquiler;
    }

    Casilla(String name) {
        this.tipo = TipoCasilla.DESCANSO;
        this.nombre = name;
    }

    Casilla(String name, MazoSorpresa m) {
        this.tipo = TipoCasilla.SORPRESA;
        this.nombre = name;
        this.mazo = m;
    }

/////////////////////// GETTERS.

    public TipoCasilla getTipo() {
        return tipo;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    float getPrecioCompra(){
        return precioCompra;
    }
    
    float getPrecioEdificar(){
        return precioEdificar;
    }
    
    int getNumCasas() {
        return numCasas;
    }
    
    int getNumHoteles() {
        return numHoteles;
    }
    
    float getPrecioAlquilerCompleto() {
        return precioBaseAlquiler * (FACTORALQUILERCALLE + numCasas*FACTORALQUILERCASA + numHoteles*FACTORALQUILERHOTEL);
    }

    public int cantidadCasasHoteles() {
        return numCasas + numHoteles;
    }

//////////////// METHODS.
    
    boolean construirCasa() {
        int inicio = numCasas;
        numCasas++;
        return inicio == numCasas-1; // Comprobamos si el número de casas ha aumentado en 1.
    }
    
    boolean construirHotel() {
        int inicio = numHoteles;
        numHoteles++;
        return inicio == numHoteles-1; // Comprobamos si el número de casas ha aumentado en 1.
    }

    public String toString(){
        String cadena = "";
        if (tipo == TipoCasilla.CALLE) {
            String dueño = "";
            try {
                dueño = propietario.getNombre();
            } catch (Exception e) {
                dueño = "No tiene dueño";
            }
            cadena = nombre + ": Compra " +  precioCompra + ", Edificar " + precioEdificar + ", Alquiler base " + precioBaseAlquiler + ", Casas " + numCasas + ", Hoteles " + numHoteles + ", Propietario: " + dueño;
        } else if (tipo == TipoCasilla.DESCANSO)
            cadena = nombre;
        else
            cadena = nombre;

        return cadena;
    } 

    void informe(int actual, ArrayList<Jugador> todos) {
        Diario.getInstance().ocurreEvento(toString() + "\n      Ha caido el jugador " + todos.get(actual).getNombre());
    } // Comparar.

    public boolean esEsteElPropietario(Jugador j) {
        return propietario == j; 
    } // Comparar

    boolean derruirCasas(int n, Jugador j) {
        boolean realizado = false;
        if (esEsteElPropietario(j) && numCasas >= n) {
            numCasas -= n;
            realizado = true;
        }
        return realizado;
    }

    public boolean tienePropietario() {
        return propietario != null;
    }

    public void tramitarAlquiler(Jugador j) {
        if (tienePropietario() && !esEsteElPropietario(j)) {
            j.pagaAlquiler(getPrecioAlquilerCompleto());
            propietario.recibe(getPrecioAlquilerCompleto());
        }
    }
}
