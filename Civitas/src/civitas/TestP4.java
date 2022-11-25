package src.civitas;

import java.util.ArrayList;

class TestP4 {
    public static void main(String[] args) {
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        Jugador j = new Jugador("Jugador test");
        jugadores.add(j);
        CasillaCalle calle = new CasillaCalle("Calle prueba", 100, 50, 20);
        System.out.println(calle.toString());
        jugadores.get(0).comprar(calle);
        System.out.println(jugadores.get(0).toString());
        jugadores.get(0).construirCasa(0);
        System.out.println(jugadores.get(0).toString()); // Cobra el coste total de la edificación. (Se ve reflejado en el saldo, 50€).
        jugadores.get(0).construirCasa(0);
        jugadores.get(0).construirCasa(0);
        jugadores.get(0).construirCasa(0);
        jugadores.get(0).construirCasa(0); // Vemos como aquí no construye la quinta casa.
        System.out.println(calle.toString());

        SorpresaConvertirme s = new SorpresaConvertirme("cae en la casilla a probar", 0);
        s.aplicarAJugador(0, jugadores);
        System.out.println("\n" + jugadores.get(0).toString() + "\nAhora el numero máximo de casas y hoteles es: " + jugadores.get(0).getCasasMax());
        jugadores.get(0).construirCasa(0); // Aquí si construye más casas hasta 8, porque es jugador especulador.
        System.out.println(jugadores.get(0).toString()); // Ha cobrado la mitad por edificar (25€).
        jugadores.get(0).construirCasa(0);
        jugadores.get(0).construirCasa(0);
        System.out.println(calle.toString());

        s.aplicarAJugador(0, jugadores);
        System.out.println("\n" + jugadores.get(0).toString() + "\nAhora el numero máximo de casas y hoteles es: " + jugadores.get(0).getCasasMax());
        // DUDA: Las casas de más construidas mientras era jugador especulador se quedan construidas??
        
    }
}