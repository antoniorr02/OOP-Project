package src.civitas;

import java.util.ArrayList;

/**
 *
 * @author antonio
 */
public class CasillaCalle extends Casilla{
    private float precioCompra, precioEdificar, precioBaseAlquiler;
    private int numCasas, numHoteles;
    private Jugador propietario;

    float FACTORALQUILERCALLE = 1.0f;
    float FACTORALQUILERCASA  = 1.0f;
    float FACTORALQUILERHOTEL = 4.0f;

/////////////////// CONSTRUCTORS.

    CasillaCalle(String nombre, float preciocompra, float precioedificar, float preciobasealquiler) {
        super(nombre);
        this.numCasas = 0;
        this.numHoteles = 0;
        this.precioCompra = preciocompra;
        this.precioEdificar = precioedificar;
        this.precioBaseAlquiler = preciobasealquiler;
        this.propietario = null;
    }

/////////////////////// GETTERS.

    int getNumCasas() {
        return numCasas;
    }

    float getPrecioCompra(){
        return precioCompra;
    }
    
    float getPrecioEdificar(){
        return precioEdificar;
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

    public boolean esEsteElPropietario(Jugador j) {
        return propietario == j; 
    }

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

    @Override
    void recibeJugador(int iactual, ArrayList<Jugador> todos) {
        informe(iactual, todos);
        Jugador j = todos.get(iactual);
        if (!tienePropietario())
            j.puedeComprarCasilla();
        else
            tramitarAlquiler(j);
    }

    boolean comprar (Jugador j) {
        propietario = j;
        return propietario.paga(precioCompra);
    }

    @Override
    public String toString(){
        String cadena = "";
        String dueño = "";
        try {
            dueño = propietario.getNombre();
        } catch (Exception e) {
            dueño = "No tiene dueño";
        }
        cadena = super.toString() + ": Compra " +  precioCompra + ", Edificar " + precioEdificar + ", Alquiler base " + precioBaseAlquiler + ", Casas " + numCasas + ", Hoteles " + numHoteles + ", Propietario: " + dueño;
        return cadena;
    } 

    void actualizaPropietarioPorConversion(Jugador j_esp) {
        propietario = j_esp;
    }

}