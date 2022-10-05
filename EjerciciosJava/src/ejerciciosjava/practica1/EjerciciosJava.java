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
        Parcela aComparar = new Parcela("nombre", 10, 20,5);
        if (nueva.igualdadEstado(aComparar))
            System.out.println("Son iguales");
        else
            System.out.println("No son iguales");

//////////////////////////////////////////////////

        Parcela prueba21 = new Parcela("nombre", 10, 20,5);
        Parcela prueba22 = new Parcela("diferente", 10, 20,5);
        if (prueba21.igualdadEstado(prueba22))
            System.out.println("Son iguales");
        else
            System.out.println("No son iguales");

//////////////////////////////////////////////////

    Parcela prueba31 = new Parcela("nombre", 10, 20,5);
    Parcela prueba32 = new Parcela("diferente", 11, 21,4);
    if (prueba31.igualdadEstado(prueba32))
        System.out.println("Son iguales");
    else
        System.out.println("No son iguales");

        
        System.out.println(nueva.getPrecioAlquilerCompleto());
    }
    
}
