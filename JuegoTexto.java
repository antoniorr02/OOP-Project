package principal;

import GUI.Vista;
import civitas.*;
import controladorCivitas.Controlador;
import vistaTextualCivitas.*;

import java.util.ArrayList;
/**
 *
 * @author antonio
 */
public class JuegoTexto {
    public static void main(String[] args) {
        String nombre1 = "Antonio";
        String nombre2 = "Pepe";
        String nombre3 = "Juan";
        ArrayList<String> nombres = new ArrayList<String>() {{ add(nombre1); add(nombre2); add(nombre3); }};
        CivitasJuego modelo = new CivitasJuego(nombres, false);
        Vista v = new VistaTextual(modelo);
        Controlador c = new Controlador(modelo, v);
        c.juega();
    }
}