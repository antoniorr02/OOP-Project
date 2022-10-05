import java.util.ArrayList;

public class Empleado {
    private String nombre;
    private ArrayList<Hotel> hoteles;

    public Empleado(String name) {
        nombre = name;
        hoteles = new ArrayList<Hotel>();
    }

    public String getNombre() {
        return nombre;
    }

    public boolean addTrabajo(Hotel hotel) {
        boolean insertado = false;
        if (hoteles.size() < 2) {
            hoteles.add(hotel);
            insertado = true;
        }
        return insertado;
    }
}