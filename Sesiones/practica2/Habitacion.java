public class Habitacion {
    private int numero;
    private int capacidad;

    public Habitacion(int n, int c) {
        numero = n;
        capacidad = c; 
    }

    public int getNumero() {
        return numero;
    }

    public int getCapacidad() {
        return capacidad;
    }
}