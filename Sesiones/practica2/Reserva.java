public class Reserva {
    private String fchaEntrada;
    private String fchaSalida;
    private Cliente cliente;
    private Hotel hotel;

    public Reserva(String entrada, String salida, Cliente c, Hotel h) {
        fchaEntrada = entrada;
        fchaSalida = salida;
        cliente = c;
        hotel = h;
    }

    public String getFechaEntrada() {
        return fchaEntrada;
    }

    public Cliente getCliente() {
        return cliente;
    }

}