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
        tablero.añadeCasilla(new CasillaCalle("Parque del Retiro", 2900, 390, 240));
        tablero.añadeCasilla(new CasillaCalle("Puerta del Sol", 1900, 300, 230));
        tablero.añadeCasilla(new CasillaSorpresa("Casilla Sorpresa", mazo));
        tablero.añadeCasilla(new CasillaCalle("Calle de Brasil", 1500, 250, 160));
        tablero.añadeCasilla(new CasillaCalle("Avenida Alfonso XIII", 2300, 500, 250));
        tablero.añadeCasilla(new CasillaCalle("Calle de Pizarro", 4000, 530, 320));
        tablero.añadeCasilla(new CasillaSorpresa("Casilla Sorpresa", mazo));
        tablero.añadeCasilla(new CasillaCalle("Calle de Bilbao", 2700, 350, 200));
        tablero.añadeCasilla(new CasillaCalle("Gran Vía", 4500, 620, 350));
        tablero.añadeCasilla(new Casilla("Parking"));
        tablero.añadeCasilla(new CasillaCalle("Calle de Bailén", 2800, 400, 230));
        tablero.añadeCasilla(new CasillaCalle("Calle de Alcalá", 3300, 470, 290));
        tablero.añadeCasilla(new CasillaSorpresa("Casilla Sorpresa", mazo));
        tablero.añadeCasilla(new CasillaCalle("Calle de las Delicias", 1300, 200, 160));
        tablero.añadeCasilla(new CasillaCalle("Avenida Onésimo Redondo", 3000, 600, 300));
        tablero.añadeCasilla(new CasillaCalle("Calle de Fernándo el Católico", 2800, 520, 280));
        tablero.añadeCasilla(new CasillaSorpresa("Casilla Sorpresa", mazo));
        tablero.añadeCasilla(new CasillaCalle("Avenida de Cataluña", 2500, 500, 200));
        tablero.añadeCasilla(new CasillaCalle("Calle Calvo Sotelo", 2000, 450, 180));
    }

    private void inicializaMazoSorpresas() {
        mazo.alMazo(new Sorpresa(TipoSorpresa.PAGARCOBRAR,"Pagas el seguro médico, 200€",-200));
        mazo.alMazo(new Sorpresa(TipoSorpresa.PAGARCOBRAR,"Multa por exceso de velocidad 300€",-300));
        mazo.alMazo(new Sorpresa(TipoSorpresa.PAGARCOBRAR,"Multa por embriaguez, pagas 100€",-100));
        mazo.alMazo(new Sorpresa(TipoSorpresa.PAGARCOBRAR," 100€",100));
        mazo.alMazo(new Sorpresa(TipoSorpresa.PAGARCOBRAR,"La banca arroja un dividendo de 200€",200));
        mazo.alMazo(new Sorpresa(TipoSorpresa.PAGARCOBRAR,"Te tocan 400 euros en la loteria de Navidad",400));
        mazo.alMazo(new Sorpresa(TipoSorpresa.PORCASAHOTEL,"Haces reparaciones en todas tus viviendas, pagas 200€ por cada propiedad",-200));
        mazo.alMazo(new Sorpresa(TipoSorpresa.PORCASAHOTEL,"Inundación provoca unos desperfectos de 100€ en todas las viviendas",-100));
        mazo.alMazo(new Sorpresa(TipoSorpresa.PORCASAHOTEL,"Recibes ayudas de 50€ a cada vivienda",50));
        mazo.alMazo(new Sorpresa(TipoSorpresa.PORCASAHOTEL,"Te indemnizan por desperfectos de 400€ en cada vivienda",400));
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
        return getJugadorActual().construirCasa(ip);
    }

    public boolean construirHotel(int ip) {
        return getJugadorActual().construirHotel(ip);
    }

    public boolean finalDelJuego() {
        boolean bancarrota = false;
        for (int i = 0; i < jugadores.size(); i++) {
            if (jugadores.get(i).enBancaRota()) {
                bancarrota = true;
                ArrayList<Jugador> orden = ranking();
                System.out.println("\nEl ranking final será:");
                for (int j = 0; j < orden.size(); j++) {
                    int posicion = j + 1;
                    System.out.println(posicion + ". " + orden.get(j).getNombre() + " con saldo: " + orden.get(j).getSaldo());
                }
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
        CasillaCalle casilla = ((CasillaCalle) tablero.getCasilla(numCasillaActual));
        boolean res = jugadorActual.comprar(casilla);
        return res;
    }
}