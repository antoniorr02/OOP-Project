package civitas;

import java.util.ArrayList;

/**
 *
 * @author antonio
 */
public class CasillaSorpresa extends Casilla{

    private Sorpresa sorpresa;
    private MazoSorpresa mazo;

    CasillaSorpresa(String name, MazoSorpresa m) {
        super(name);
        this.mazo = m;
    }

    @Override
    void recibeJugador(int iactual, ArrayList<Jugador> todos) {
        sorpresa  = mazo.siguiente();
        informe(iactual, todos);
        sorpresa.aplicarAJugador(iactual, todos);
    }
    
}