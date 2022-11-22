package ejercicios;

public class CasillaCalle extends Casilla{
    private int numCasas;

    // 1. Reutilización:
    CasillaCalle(String n, int num) {
        super(n);
        numCasas = num;
    }

    // 2. Redefinición o sobrescritura completa:
    /*@Override
    boolean recibeJugador() {
        System.out.println("Soy una calle y he recibido un jugador");
        return true;
    }*/

    // 3. Redifinición o sobrescritura parcial:
    @Override
    boolean recibeJugador() {
        System.out.println("Soy una calle y he recibido un jugador");
        return super.recibeJugador();
    }

    void construirCasa() {
        numCasas++;
        System.out.println("El número de casas tras la construcción es de: " + numCasas);
    }
} 