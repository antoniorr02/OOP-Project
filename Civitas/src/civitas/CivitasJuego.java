package civitas;

import java.util.ArrayList;

public class CivitasJuego {
    private int indiceJugadorActual;
    private Tablero tablero;
    private MazoSorpresa mazo;
    private ArrayList<Jugador> jugadores;
    private GestorEstados estado;

    public CivitasJuego(String[] nombres, boolean debug) {
        if (nombres.length == 4) {
            for (int i = 0; i < 4; i++) {
                jugadores.set(i, new Jugador(nombres[i]));
            }
        } else {
            System.out.println("Numero de jugadores incorrecto");
            System.exit(-1);
        }
        
        estado.estadoInicial();
        Dado.getInstance().setDebug(debug);
        mazo = new MazoSorpresa(debug);
    }

    
}