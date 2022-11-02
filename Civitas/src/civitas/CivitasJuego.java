package src.civitas;

import java.util.ArrayList;
import java.util.Collections;

public class CivitasJuego {
    private int indiceJugadorActual;
    private Tablero tablero;
    private MazoSorpresa mazo;
    private ArrayList<Jugador> jugadores;
    private GestorEstados gestor;
    private EstadoJuego estado;

    public CivitasJuego(String[] nombres, boolean debug) {
        jugadores = new ArrayList<Jugador>();
        if (nombres.length <= 4) {
            for (int i = 0; i < nombres.length; i++) {
                jugadores.add(new Jugador(nombres[i]));
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
        inicializaMazoSorpresas();
        inicializaTablero(mazo);
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public int getIndiceJugadorActual() {
        return indiceJugadorActual;
    }

    private void inicializaTablero(MazoSorpresa m) {
        tablero = new Tablero();
    } // No sé que más poner

    private void inicializaMazoSorpresas() {

    } // Cuales son las cartas??
    
    public Jugador getJugadorActual() {
        return jugadores.get(indiceJugadorActual);
    }

    private void pasarTurno() {
        indiceJugadorActual = (indiceJugadorActual+1) % jugadores.size();
    }

    public void siguientePasoCompletado (OperacionJuego operacion) {
        estado = gestor.siguienteEstado(getJugadorActual(), estado, operacion);
    }

    public boolean construirCasa(int ip) {
        return getJugadorActual().getPropiedades().get(ip).construirCasa();
    }

    public boolean construirHotel(int ip) {
        return getJugadorActual().getPropiedades().get(ip).construirHotel();
    }

    public boolean finalDelJuego() {
        boolean bancarrota = false;
        for (int i = 0; i < jugadores.size(); i++) {
            if (jugadores.get(i).enBancaRota()) {
                bancarrota = true;
                ranking().toString();
                break;
            }
        }
        return bancarrota;
    }

    private ArrayList<Jugador> ranking() {
        ArrayList<Jugador> r = new ArrayList<Jugador>();
        for (int i = 0; i < jugadores.size(); i++) {
            r.add(jugadores.get(i));
        }
        Collections.sort(r); // Esto coge el compareTo?
        return r;
    }

    private void contabilizarPasosPorSalida() {
        if (tablero.computarPasoPorSalida())
            getJugadorActual().pasaPorSalida(); 
    }

    private void avanzaJugador() {
        Jugador jugadorActual = getJugadorActual();
        int posicionActual = jugadorActual.getCasillaActual();
        int tirada = Dado.getInstance().tirar();
        int posicionNueva = tablero.nuevaPosicion(posicionActual, tirada);
        Casilla casilla = tablero.getCasilla(posicionNueva);
        contabilizarPasosPorSalida();
        jugadorActual.moverACasilla(posicionNueva);
        casilla.recibeJugador(indiceJugadorActual, jugadores);
    }

    public OperacionJuego siguientePaso() {
        Jugador jugadorActual = getJugadorActual();
        OperacionJuego operacion = gestor.siguienteOperacion(jugadorActual, estado);
        if (operacion == OperacionJuego.PASAR_TURNO) {
            pasarTurno();
            siguientePasoCompletado(operacion);
        } else if (operacion == OperacionJuego.AVANZAR) {
            avanzaJugador();
            siguientePasoCompletado(operacion);
        }
        return operacion;
    }

    public boolean comprar() {
        Jugador jugadorActual = getJugadorActual();
        int numCasillaActual = jugadorActual.getCasillaActual();
        Casilla casilla = tablero.getCasilla(numCasillaActual);
        boolean res = jugadorActual.comprar(casilla);
        return res;
    }
}