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
        for (int i = 0 ; i <= 100; i++) {
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
        
            int uno = 0;
            int dos = 0;
            int tres = 0;
            int cuatro = 0;
            int cinco = 0;
            int seis = 0;

        for(int i = 1; i < 30; i++){
            
            Dado.getInstance().setDebug(false);
            Dado.getInstance().tirar();
            int n = Dado.getInstance().getUltimoResultado();
            switch(n){
                case 1: if (uno == 0)
                            System.out.println("En la tirada " + i + " ha salido un " + n);
                            uno = 1;                            
                    break;
                case 2: if (dos == 0)
                            System.out.println("En la tirada " + i + " ha salido un " + n);
                            dos = 1;
                    break;
                case 3: if (tres == 0)
                            System.out.println("En la tirada " + i + " ha salido un " + n);
                            tres = 1;
                    break;
                case 4: if (cuatro == 0)
                            System.out.println("En la tirada " + i + " ha salido un " + n);
                            cuatro = 1;
                    break;
                case 5: if (cinco == 0)
                            System.out.println("En la tirada " + i + " ha salido un " + n);
                            cinco = 1;
                    break;
                case 6: if (seis == 0)
                            System.out.println("En la tirada " + i + " ha salido un " + n);
                            seis = 1;
        
                }

        }

        Tablero tablero = new Tablero();
        Casilla nueva1 = new Casilla(TipoCasilla.CALLE,"Reyes Católicos", 10, 20,5);
        Casilla nueva2 = new Casilla(TipoCasilla.CALLE,"Camino de Ronda", 7,15,3);
        tablero.añadeCasilla(nueva1);
        tablero.añadeCasilla(nueva2);
        System.out.println(tablero.getCasilla(0).toString());
        System.out.println(tablero.getCasilla(1).toString());
    }
    
}