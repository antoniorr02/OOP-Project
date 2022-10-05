import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        Hotel hotel1 = new Hotel("Palace", "Granada",5);
        Hotel hotel2 = new Hotel("Saray", "Granada", 4);
        System.out.println(Hotel.getNUM_HOTELES());
        
        Director director = new Director("Pepe", 958123123);
        hotel1.setDirector(director);
        System.out.println("Director del hotel 1: " + hotel1.getDirector().getNombre());
        
        Cliente cliente = new Cliente("123456789", "Antonio");
        Cliente cliente2 = new Cliente("123456789", "Blanca");
        hotel2.addReserva(cliente, "21 Octubre", "23 Octubre");
        hotel2.addReserva(cliente2, "21 Octubre", "23 Octubre");
        ArrayList<Reserva> reservas = hotel2.getReservas();
        System.out.println("Reservas: Nombre y fecha de reserva");
        for (int i = 0; i < reservas.size(); i++) {
            System.out.println(reservas.get(i).getCliente().getNombre() + "     " + reservas.get(i).getFechaEntrada());
        }

        Empleado empleado = new Empleado("José");
        hotel1.addEmpleado(empleado);
        System.out.println("Numero de trabajadores del hotel " + hotel1.getNombre() + ": " + hotel1.numEmpleados());

        Habitacion habitacion1 = new Habitacion(1, 1);
        hotel1.addHabitacion(1, 1);
        hotel1.addHabitacion(2,2);
        ArrayList<Integer> nhabitaciones = hotel1.buscarHabitacionCapacidad(1);
        System.out.println("Los números de habitación con la capacidad buscada en el hotel " + hotel1.getNombre() + " son: ");
        for (int i = 0; i < nhabitaciones.size(); i++) {
            System.out.println(nhabitaciones.get(i));
        }
    }
}