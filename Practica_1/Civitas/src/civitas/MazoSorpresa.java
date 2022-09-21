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

    protected MazoSorpresa() {
        init();
        debug = false;
    }

    protected MazoSorpresa(boolean d) {
        debug = d;
        init();
        if (debug) {}
            // ver como se informa en diario.
    }

    protected void alMazo(Sorpresa s) {
        if(!barajada)
            sorpresas.add(s);
    }

    protected Sorpresa siguiente() {
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