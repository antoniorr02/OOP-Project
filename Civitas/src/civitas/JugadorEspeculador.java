package src.civitas;

class JugadorEspeculador extends Jugador {

    static private int CasasMaxEsp = 8;
    static private int HotelesMaxEsp = 8;

    public JugadorEspeculador(Jugador j) {
        super(j);
    }

    @Override
    int getCasasMax() {
        return CasasMaxEsp;
    }
    
    @Override
    int getHotelesMax() {
        return HotelesMaxEsp;
    }

    @Override
    boolean paga(float cantidad) {
        return modificaSaldo((cantidad/2)*(-1));
    }

    @Override
    Jugador convertir() {
        Jugador j = new Jugador(this);
        actualizaPropiedadesPorConversion(j);
        j.setEspeculador(false); // Ahora no es jugador especulador.
        return j;
    }

}