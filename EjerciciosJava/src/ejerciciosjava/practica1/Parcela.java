package ejerciciosjava.practica1;

/**
 *
 * @author antonio
 */
public class Parcela {
    private String nombre;
    private float precioCompra, precioEdificar, precioBaseAlquiler;
    private int numCasas, numHoteles;
    
    float FACTORALQUILERCALLE = 1.0f;
    float FACTORALQUILERCASA  = 1.0f;
    float FACTORALQUILERHOTEL = 4.0f;

    public Parcela(String name, float preciocompra, float precioedificar, float preciobasealquiler) {
        this.nombre = name;
        this.precioCompra = preciocompra;
        this.precioEdificar = precioedificar;
        this.precioBaseAlquiler = preciobasealquiler;
        this.numCasas = 0;
        this.numHoteles = 0;        
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
        return inicio == numHoteles-1; // Comprobamos si el número de hoteles ha aumentado en 1.
    }

    public boolean igualdadEstado(Parcela otraParcela) {
        return (otraParcela.nombre.equals(nombre) && otraParcela.precioCompra == precioCompra && otraParcela.precioEdificar == precioEdificar && otraParcela.precioBaseAlquiler == precioBaseAlquiler && otraParcela.numCasas == numCasas && otraParcela.numHoteles == numHoteles);
    }
}
