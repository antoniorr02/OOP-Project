package src.civitas;

import java.util.ArrayList;

/**
 *
 * @author antonio
 */
abstract class Sorpresa {
    private String texto;
    private int valor;
    //private MazoSorpresa mazo; // Misma duda de su uso que en casilla.

    abstract void aplicarAJugador(int actual, ArrayList<Jugador> todos);

    int getValor() {
        return valor;
    }

    Sorpresa(String text, int v) {
        texto = text;
        valor = v;
    }

    void informe(int actual, ArrayList<Jugador> todos) {
        Diario.getInstance().ocurreEvento(toString() + "\n      Se está aplicando la sorpresa al jugador " + todos.get(actual).getNombre());
    }

    public String toString() {
        return texto;
    }
    
}
