package civitas;

import java.util.ArrayList;

public class SorpresaPagarCobrar extends Sorpresa {

    SorpresaPagarCobrar(String text, int v) {
        super(text, v);
    }

    @Override
    void aplicarAJugador(int actual, ArrayList<Jugador> todos) {
        informe(actual, todos);
        todos.get(actual).modificaSaldo(getValor());
    }
}