package civitas;

import java.util.ArrayList;

import javax.swing.text.StyledEditorKit.BoldAction;

public class CivitasJuego {
    private int indiceJugadorActual;
    private Tablero tablero;
    private MazoSorpresa mazo;
    private ArrayList<Jugador> jugadores;
    private GestorEstados gestor;
    private EstadoJuego estado;

    public CivitasJuego(String[] nombres, boolean debug) {
        jugadores = null;
        if (nombres.length <= 4) {
            for (int i = 0; i < nombres.length; i++) {
                jugadores.set(i, new Jugador(nombres[i]));
            }
        } else {
            System.out.println("Numero de jugadores incorrecto");
            System.exit(-1);
        }

        gestor = new GestorEstados();
        estado = gestor.estadoInicial();
        Dado.getInstance().setDebug(debug);
        indiceJugadorActual = Dado.getInstance().quienEmpieza(jugadores.size());
        mazo = new MazoSorpresa(debug);
        tablero = new Tablero();
        inicializaTablero(mazo);
    }

    private void inicializaTablero(MazoSorpresa m) {

    }

    private void inicializaMazoSorpresas() {

    }
    
    public Jugador getJugadorActual() {
        return jugadores.get(indiceJugadorActual);
    }

    private void pasarTurno() {
        indiceJugadorActual = (indiceJugadorActual+1) / jugadores.size();
    }

    public void siguientePasoCompletado (OperacionJuego operacion) {
        estado = gestor.siguienteEstado(getJugadorActual(), estado, operacion);
    }

    public boolean construirCasa(int ip) {
        return getJugadorActual().getPropiedades().get(ip).construirCasa();

    public boolean construirHotel(int ip) {
        return getJugadorActual().getPropiedades().get(ip).construirHotel();
    }

    public boolean finalDelJuego() {
        boolean bancarrota = false;
        for (int i = 0; i < jugadores.size() i++) {
            if (jugadores.get(i).getSaldo() < 0) {
                bancarrota = true;
                break;
            }
        }
        return bancarrota;
    }

    private ArrayList<Jugador> ranking() {
        // Ns como tener en cuenta el compareTo
    }

    private void contabilizarPasosPorSalida() {
        if (tablero.computarPasoPorSalida()) // Invent, está mal!
            getJugadorActual().pasaPorSalida(); 
    }
}