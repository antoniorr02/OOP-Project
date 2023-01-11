package civitas;

import java.util.ArrayList;

/**
 *
 * @author antonio
 */
public class Casilla {
    private String nombre;
    private ArrayList<Jugador> jugadoresCasilla;
    
/////////////////// CONSTRUCTORS.

    Casilla(String name) {
        this.nombre = name;
        this.jugadoresCasilla = new ArrayList<Jugador>();
    }

/////////////////////// GETTERS.
    
    public String getNombre(){
        return nombre;
    }
    
    public ArrayList<Jugador> getJugadores() {
        return jugadoresCasilla;
    }

//////////////// METHODS.
    public void entraJugador(Jugador j) {
        jugadoresCasilla.add(j); // Jugador en la casilla actual.
    }

    public void saleJugador() {
        if (jugadoresCasilla.size() >= 1)
            jugadoresCasilla.remove(0); // Elimina el primer elemento, pues el jugador que saldrá de la casilla será el primero que llego. (se sigue orden de juego)
    }
    
    public String toString(){
        String cadena = nombre;
        return cadena;
    } 

    void informe(int actual, ArrayList<Jugador> todos) {
        Diario.getInstance().ocurreEvento(toString() + "\n      Ha caido el jugador " + todos.get(actual).getNombre());
    }

    void recibeJugador(int iactual, ArrayList<Jugador> todos){
        informe(iactual, todos);
    }

}
