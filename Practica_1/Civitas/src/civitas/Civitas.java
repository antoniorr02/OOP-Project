/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package civitas;

/**
 *
 * @author antonio
 */
public class Civitas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        int n0 = 0;
        int n1 = 0;
        int n2 = 0;
        int n3 = 0;
        for (int i =0 ; i <= 100; i++) {
            int n = Dado.getInstance().quienEmpieza(4);
            switch(n){
                case 0: n0++;
                    break;
                case 1: n1++;
                    break;
                case 2: n2++;
                    break;
                case 3: n3++;
            }
        }
        System.out.println("J1:" + n0 + ", J2:" + n1 + ", J3:" + n2 + ", J4:" + n3);

        for (int i = 0; i < 5; i++) {
            Dado.getInstance().setDebug(true);
            System.out.println("Debug: true --> " + Dado.getInstance().tirar());
        }
        for (int i = 0; i < 5; i++) {
            Dado.getInstance().setDebug(false);
            System.out.println("Debug: false --> " + Dado.getInstance().tirar());
        }
        
        System.out.println("getUltimoResultado: " + Dado.getInstance().getUltimoResultado());

        // No entiendo el enunciado del apartado 4 del main.

        Tablero tablero = new Tablero();
        Casilla nueva1 = new Casilla(TipoCasilla.CALLE,"Reyes Católicos", 10, 20,5);
        Casilla nueva2 = new Casilla(TipoCasilla.CALLE,"Camino de Ronda", 7,15,3);
        tablero.añadeCasilla(nueva1); // Este método falla y no sé porqué (revisar)
        tablero.añadeCasilla(nueva2);
        System.out.println(tablero.getCasilla(0).toString());
        System.out.println(tablero.getCasilla(1).toString());
    }
    
}