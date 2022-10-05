package civitas;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author antonio
 */
public class MazoSorpresa {
    private ArrayList<Sorpresa> sorpresas;
    private boolean barajada;
    private int usadas;
    private boolean debug;

    private void init() {
        sorpresas = null;
        barajada = false;
        usadas = 0;
    }

    MazoSorpresa() {
        init();
        debug = false;
    }

    MazoSorpresa(boolean d) {
        debug = d;
        init();
        if (debug) {}
            Diario.getInstance().ocurreEvento("Modo debug");
    }

    void alMazo(Sorpresa s) {
        if(!barajada)
            sorpresas.add(s);
    }

    Sorpresa siguiente() {
        if ((!barajada || usadas == sorpresas.size()) && !debug) {
            Collections.shuffle(sorpresas);
            usadas = 0;
            barajada = true;
        }
        usadas++;
        Sorpresa seleccionada = sorpresas.get(0);
        sorpresas.remove(0);
        sorpresas.add(seleccionada);
        return seleccionada;
    }
}