
package civitas;

public class Jugador {

    static private int CasasMax = 4;
    static private int CasasPorHotel = 4;
    static private int HotelesMax = 4;
    static private float PasoPorSalida = 1000;
    static private float SaldoInicial = 7500;

    private int casillaActual;
    private String nombre;
    private boolean puedeComprar;
    private float saldo;
    private Casilla casilla; // Revisar este atributo, aunque creo que está bien.
    

    public boolean getPuedeComprar() {
        return puedeComprar;
    }

    public boolean tieneAlgoQueGestionar() { // Revisar visibilidad
        return true; // Implementar... 
    }
}