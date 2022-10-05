import java.util.ArrayList;

public class Hotel {
    private static int NUM_HOTELES = 0;
    private String nombre;
    private String ciudad;
    private int estrellas;
    private Director director;
    private ArrayList<Reserva> reservas;
    private ArrayList<Empleado> empleados;

    public Hotel(String name, String city, int stars){
        NUM_HOTELES++;
        nombre = name;
        ciudad = city;
        estrellas = stars;
        director = null;
        reservas = new ArrayList<Reserva>();
        empleados = new ArrayList<Empleado>();
    }

    public static int getNUM_HOTELES() {
        return NUM_HOTELES;
    }

    public void setDirector(Director n) {
        director = n;
    }

    public Director getDirector() {
        return director;
    }

    public String getNombre() {
        return nombre;
    }

    public void addReserva(Cliente cliente, String fchaEntrada, String fchaSalida) {
        Reserva r = new Reserva(fchaEntrada, fchaSalida, cliente, this);
        reservas.add(r);
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public boolean addEmpleado(Empleado empleado) {
        boolean insertado = false;
        if(empleado.addTrabajo(this)){
            empleados.add(empleado);
            insertado = true;
        }
        return insertado;
    }

    public int numEmpleados() {
        return empleados.size();
    }


}