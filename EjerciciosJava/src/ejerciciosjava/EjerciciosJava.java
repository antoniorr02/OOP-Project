package ejerciciosjava;

/**
 *
 * @author antonio
 */
public class EjerciciosJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Parcela nueva = new Parcela("nombre", 10, 20,5);
        System.out.println(nueva.getPrecioAlquilerCompleto());
    }
    
}
