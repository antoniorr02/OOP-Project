package src.vistaTextualCivitas;

import src.civitas.Casilla;
import src.civitas.CivitasJuego;
import src.civitas.Diario;
import src.civitas.OperacionJuego;
import src.controladorCivitas.Respuesta;
import src.civitas.OperacionInmobiliaria;
import src.civitas.Jugador;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;



public class VistaTextual implements Vista {
  
    
  private static String separador = "=====================";
  
  private Scanner in;
  
  CivitasJuego juegoModel;
  
  public VistaTextual (CivitasJuego juegoModel) {
    in = new Scanner (System.in);
    this.juegoModel=juegoModel;
  }
  
  
           
 public  void pausa() {
    System.out.print ("\nPulsa una tecla");
    in.nextLine();
  }

  int leeEntero (int max, String msg1, String msg2) {
    Boolean ok;
    String cadena;
    int numero = -1;
    do {
      System.out.print (msg1);
      cadena = in.nextLine();
      try {  
        numero = Integer.parseInt(cadena);
        ok = true;
      } catch (NumberFormatException e) { // No se ha introducido un entero
        System.out.println (msg2);
        ok = false;  
      }
      if (ok && (numero < 0 || numero >= max)) {
        System.out.println (msg2);
        ok = false;
      }
    } while (!ok);

    return numero;
  }

  int menu (String titulo, ArrayList<String> lista) {
    String tab = "  ";
    int opcion;
    System.out.println (titulo);
    for (int i = 0; i < lista.size(); i++) {
      System.out.println (tab+i+"-"+lista.get(i));
    }

    opcion = leeEntero(lista.size(),
                          "\n"+tab+"Elige una opción: ",
                          tab+"Valor erróneo");
    return opcion;
  }



  @Override
  public void actualiza() {
    // TODO Auto-generated method stub
    
  }



  @Override
  public Respuesta comprar() {
    // TODO Auto-generated method stub
    return null;
  }



  @Override
  public OperacionInmobiliaria elegirOperacion() {
    // TODO Auto-generated method stub
    return null;
  }



  @Override
  public int elegirPropiedad() {
    // TODO Auto-generated method stub
    return 0;
  }



  @Override
  public void mostrarSiguienteOperacion(OperacionJuego operación) {
    // TODO Auto-generated method stub
    
  }



  @Override
  public void mostrarEventos() {
    // TODO Auto-generated method stub
    
  }

}
