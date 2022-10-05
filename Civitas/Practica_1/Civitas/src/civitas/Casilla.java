package civitas;

/**
 *
 * @author antonio
 */
public class Casilla {
    private TipoCasilla tipo;
    private String nombre;
    private float precioCompra, precioEdificar, precioBaseAlquiler;
    private int numCasas, numHoteles;

    float FACTORALQUILERCALLE = 1.0f;
    float FACTORALQUILERCASA  = 1.0f;
    float FACTORALQUILERHOTEL = 4.0f;
    
    public Casilla(TipoCasilla type, String name, float preciocompra, float precioedificar, float preciobasealquiler) {
        this.tipo = type;
        this.nombre = name;
        this.precioCompra = preciocompra;
        this.precioEdificar = precioedificar;
        this.precioBaseAlquiler = preciobasealquiler;
        this.numCasas = 0;
        this.numHoteles = 0;        
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
}
