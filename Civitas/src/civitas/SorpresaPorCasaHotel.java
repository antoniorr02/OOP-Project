package civitas;

import java.util.ArrayList;

public class SorpresaPorCasaHotel extends Sorpresa {

    SorpresaPorCasaHotel(String text, int v) {
        super(text, v);
    }

    @Override
    void aplicarAJugador(int actual, ArrayList<Jugador> todos) {
        informe(actual, todos);
        int numCasasHoteles = 0;
        for (int i = 0; i < todos.get(actual).getPropiedades().size(); i++) {
            numCasasHoteles += ((CasillaCalle) todos.get(actual).getPropiedades().get(i)).cantidadCasasHoteles();
        }
        todos.get(actual).modificaSaldo(getValor() * numCasasHoteles);
    }
}