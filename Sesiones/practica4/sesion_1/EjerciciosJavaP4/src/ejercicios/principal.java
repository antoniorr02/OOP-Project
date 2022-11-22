package ejercicios;

import java.util.ArrayList;

public class principal {
    public static void main(String[] args) {
        Casilla casilla = new Casilla("Camino de Ronda");
        CasillaCalle casilla_calle = new CasillaCalle("Etsiit", 4);
        casilla.recibeJugador();
        System.out.println("-------------------");
        casilla_calle.recibeJugador();
        casilla_calle.construirCasa();
        System.out.println("-------------------");

        ArrayList<Casilla> tablero = new ArrayList<Casilla>();
        tablero.add(casilla);
        tablero.add(casilla_calle);
        //((CasillaCalle) tablero.get(0)).construirCasa(); // Esto no funciona.
        ((CasillaCalle) tablero.get(1)).construirCasa(); // Esto funciona.
        System.out.println("-------------------");

        CasillaCalle casilla1 = new CasillaCalle("casilla1", 0);
        Casilla casilla2 = casilla1;
        casilla1.recibeJugador();
        casilla2.recibeJugador();
        casilla1.construirCasa();
        //casilla2.construirCasa(); // Esto no funciona, ya que el padre no conoce la variable numCasas??

        //DUDA: Entonces el padre puede usar métodos que solo utilicen los parámetros que hederó su hijo?
    }
} 