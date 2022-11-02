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
        tablero.añadeCasilla(new Casilla("Avenida Europa", 2500, 500, 200));
        tablero.añadeCasilla(new Casilla("Calle Nueva", 2000, 450, 180));
        tablero.añadeCasilla(new Casilla("Casilla Sorpresa", mazo));
        tablero.añadeCasilla(new Casilla("Calle Perdida", 1500, 250, 160));
        tablero.añadeCasilla(new Casilla("Plaza España", 2300, 500, 250));
        tablero.añadeCasilla(new Casilla("Paseo de los Pibes", 4000, 530, 320));
        tablero.añadeCasilla(new Casilla("Casilla Sorpresa", mazo));
        tablero.añadeCasilla(new Casilla("Calle de la Fuente", 2800, 400, 230));
        tablero.añadeCasilla(new Casilla("Campus de la Cartuja", 3300, 470, 290));
        tablero.añadeCasilla(new Casilla("Parking"));
        tablero.añadeCasilla(new Casilla("Avenida Victoria", 2700, 350, 200));
        tablero.añadeCasilla(new Casilla("Gran Vía", 4500, 620, 350));
        tablero.añadeCasilla(new Casilla("Casilla Sorpresa", mazo));
        tablero.añadeCasilla(new Casilla("Calle Estudiantes", 1300, 200, 160));
        tablero.añadeCasilla(new Casilla("Cibeles", 3000, 600, 300));
        tablero.añadeCasilla(new Casilla("Avenida Granada", 2800, 520, 280));
        tablero.añadeCasilla(new Casilla("Casilla Sorpresa", mazo));
        tablero.añadeCasilla(new Casilla("Travesía de Locos", 2900, 390, 240));
        tablero.añadeCasilla(new Casilla("Carretera de Jaén", 1900, 300, 230));
    }

    private void inicializaMazoSorpresas() {
        mazo.alMazo(new Sorpresa(TipoSorpresa.PAGARCOBRAR,"Rompes una farola de una pedrada, pagas 100€",-100));
        mazo.alMazo(new Sorpresa(TipoSorpresa.PAGARCOBRAR,"Te rompes la rodilla y pagas al médico 200€",-200));
        mazo.alMazo(new Sorpresa(TipoSorpresa.PAGARCOBRAR,"Robas una joyeria y te pilla la policía, pagas 300€",-300));
        mazo.alMazo(new Sorpresa(TipoSorpresa.PAGARCOBRAR,"Ganas concurso de belleza, recibes 100€",100));
        mazo.alMazo(new Sorpresa(TipoSorpresa.PAGARCOBRAR,"Ganas la quiniela, recibes 200€",200));
        mazo.alMazo(new Sorpresa(TipoSorpresa.PAGARCOBRAR,"Eres un potroso, encuentras un billete de 500€ en la acera",500));
        mazo.alMazo(new Sorpresa(TipoSorpresa.PORCASAHOTEL,"Haces reformas en todas tus viviendas, pagas 200€ por cada propieda",-200));
        mazo.alMazo(new Sorpresa(TipoSorpresa.PORCASAHOTEL,"Viene un huracán y gastas en arreglos 500€ por vivienda",-500));
        mazo.alMazo(new Sorpresa(TipoSorpresa.PORCASAHOTEL,"Pedro Sanchez da ayudas de 200€ a cada vivienda",200));
        mazo.alMazo(new Sorpresa(TipoSorpresa.PORCASAHOTEL,"Vendes todos tus muebles de cada vivienda, ganas 500€ por vivienda",500));
    }
    
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