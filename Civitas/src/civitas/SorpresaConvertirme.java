package civitas;

import java.util.ArrayList;

class SorpresaConvertirme extends Sorpresa {

    public SorpresaConvertirme(String text, int v) {
        super(text, v);
    }

    @Override
    void aplicarAJugador(int actual, ArrayList<Jugador> todos) {
        todos.set(actual, todos.get(actual).convertir());
    }

}