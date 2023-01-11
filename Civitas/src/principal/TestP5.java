package principal;

import java.util.ArrayList;

import GUI.CapturaNombres;
import GUI.CivitasView;
import civitas.CivitasJuego;
import controladorCivitas.Controlador;
/**
 *
 * @author antonio
 */
public class TestP5 {
    public static void main(String[] args) {
        CivitasView v = new CivitasView();
        CapturaNombres cap = new  CapturaNombres(v, true);
        ArrayList<String> nombres = cap.getNombres();
        CivitasJuego modelo = new CivitasJuego(nombres, true);
        Controlador c = new Controlador(modelo, v);
        v.setCivitasJuego(modelo);
        c.juega();
    }
}