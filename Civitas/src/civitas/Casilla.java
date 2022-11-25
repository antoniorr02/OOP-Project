package src.civitas;

import java.util.ArrayList;

/**
 *
 * @author antonio
 */
public class Casilla {
    private String nombre;
    
/////////////////// CONSTRUCTORS.

    Casilla(String name) {
        this.nombre = name;
    }

/////////////////////// GETTERS.
    
    public String getNombre(){
        return nombre;
    }

//////////////// METHODS.

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
