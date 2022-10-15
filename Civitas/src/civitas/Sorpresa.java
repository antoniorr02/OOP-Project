package civitas;

import java.util.ArrayList;

/**
 *
 * @author antonio
 */
public class Sorpresa {
    private String texto;
    private int valor;
    private TipoSorpresa tipo;
    private MazoSorpresa mazo; // Misma duda de su uso que en casilla.

    public Sorpresa(TipoSorpresa t, String text, int v) {
        texto = text;
        valor = v;
        tipo = t;
    }

    private void informe(int actual, ArrayList<Jugador> todos) {
        Diario.getInstance().ocurreEvento(toString() + "\n      Se está aplicando la sorpresa al jugador " + todos.get(actual).getNombre());
    }

    void aplicarAJugador(int actual, ArrayList<Jugador> todos) {

    }

    private void aplicarAJugador_pagarCobrar(int actual, ArrayList<Jugador> todos) {

    }

    private void aplicarAJugador_porCasaHotel(int actual, ArrayList<Jugador> todos) {

    }

    public String toString() {
        return texto;
    }
}
