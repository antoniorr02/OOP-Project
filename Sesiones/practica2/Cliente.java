import java.util.ArrayList;

public class Cliente {
    private String dni;
    private String nombre;
    private ArrayList<Reserva> reservas;

    public Cliente(String id, String n) {
        dni = id;
        nombre = n;
        reservas = new ArrayList<Reserva>();
    }

    public String getNombre() {
        return nombre;
    }

    public void addReserva(Reserva r) {
        reservas.add(r);
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }
    
}