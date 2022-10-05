public class Director {
    private String nombre;
    private long telefono;

    public Director(String name, long num) {
        nombre = name;
        telefono = num;
    }

    public String getNombre() {
        return nombre;
    }
}