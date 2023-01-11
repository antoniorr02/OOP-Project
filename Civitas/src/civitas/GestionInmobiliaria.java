package civitas;

public class GestionInmobiliaria {
    private int propiedad;
    private OperacionInmobiliaria operacion;

    public GestionInmobiliaria(OperacionInmobiliaria gest, int ip) {
        propiedad = ip; // Ver si es necesaria alguna comprobación antes de asignar
        operacion = gest;
    }

    public int getPropiedad() {
        return propiedad;
    }

    public OperacionInmobiliaria getOperacion() {
        return operacion;
    }
}