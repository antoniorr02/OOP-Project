package src.controladorCivitas;

import src.civitas.CivitasJuego;
import src.civitas.GestionInmobiliaria;
import src.civitas.OperacionInmobiliaria;
import src.civitas.OperacionJuego;
import src.vistaTextualCivitas.*;

public class Controlador {
    private CivitasJuego juego;
    private Vista vista;

    public Controlador(CivitasJuego j, Vista v) {
        juego = j;
        vista = v;
    } // Lo he puesto público, ns si está bien
    
    public void juega() {
        vista.actualiza();
        vista.pausa();
        OperacionJuego op = juego.siguientePaso();
        vista.mostrarSiguienteOperacion(op);
        if (op != OperacionJuego.PASAR_TURNO) {
            vista.mostrarEventos();
        }
        if (!juego.finalDelJuego()) {
            if (op == OperacionJuego.COMPRAR) {
                if (vista.comprar() == Respuesta.SI) {
                    juego.comprar();
                    juego.siguientePasoCompletado(op);
                }
            }
            if (op == OperacionJuego.GESTIONAR) {
                OperacionInmobiliaria accion = vista.elegirOperacion();
                if (accion != OperacionInmobiliaria.TERMINAR) {
                    int ip = vista.elegirPropiedad();
                    GestionInmobiliaria ges = new GestionInmobiliaria(accion, ip);
                    if (ges.getOperacion() == OperacionInmobiliaria.CONSTRUIR_CASA) {
                        juego.construirCasa(ip);
                    } else {
                        juego.construirHotel(ip);
                    }
                } else {
                    juego.siguientePasoCompletado(op);
                } 
            }
        } else {
            juego.finalDelJuego();
            vista.actualiza();
        }
    }
} 