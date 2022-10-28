package src.civitas;

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

    Sorpresa(TipoSorpresa t, String text, int v) {
        texto = text;
        valor = v;
        tipo = t;
    }

    private void informe(int actual, ArrayList<Jugador> todos) {
        Diario.getInstance().ocurreEvento(toString() + "\n      Se está aplicando la sorpresa al jugador " + todos.get(actual).getNombre());
    }

    void aplicarAJugador(int actual, ArrayList<Jugador> todos) {
        if (tipo == TipoSorpresa.PAGARCOBRAR) {
            aplicarAJugador_pagarCobrar(actual, todos);
        } else if (tipo == TipoSorpresa.PORCASAHOTEL) {
            aplicarAJugador_porCasaHotel(actual, todos);
        }
    }

    private void aplicarAJugador_pagarCobrar(int actual, ArrayList<Jugador> todos) {
        informe(actual, todos);
        todos.get(actual).modificaSaldo(this.valor);
    }

    private void aplicarAJugador_porCasaHotel(int actual, ArrayList<Jugador> todos) {
        informe(actual, todos);
        int numCasasHoteles = 0;
        for (int i = 0; i < todos.get(actual).getPropiedades().size(); i++) {
            numCasasHoteles += todos.get(actual).getPropiedades().get(i).cantidadCasasHoteles();
        }
        todos.get(actual).modificaSaldo(this.valor * numCasasHoteles);
    }

    public String toString() {
        return texto;
    }
}
