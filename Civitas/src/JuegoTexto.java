package src;

import src.civitas.*;
import src.controladorCivitas.Controlador;
import src.vistaTextualCivitas.*;
/**
 *
 * @author antonio
 */
public class JuegoTexto {
    public static void main(String[] args) {
        String[] nombres= {"Antonio", "Pepe", "Juan"};
        CivitasJuego modelo = new CivitasJuego(nombres, true);
        Vista v = new VistaTextual(modelo);
        Controlador c = new Controlador(modelo, v);
        c.juega();
    }
}