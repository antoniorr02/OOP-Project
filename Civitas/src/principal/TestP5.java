package principal;

import GUI.*;
import src.civitas.*;
import src.controladorCivitas.Controlador;

import java.util.ArrayList;
/**
 *
 * @author antonio
 */
public class TestP5 {
    public static void main(String[] args) {
        CivitasView v = new CivitasView();
        CapturaNombres cap = new  CapturaNombres(v, true);
        ArrayList<String> nombres = cap.getNombres();
        CivitasJuego modelo = new CivitasJuego(nombres, false);
        Controlador c = new Controlador(modelo, v);
        v.setCivitasJuego(modelo);
        c.juega();
    }
}