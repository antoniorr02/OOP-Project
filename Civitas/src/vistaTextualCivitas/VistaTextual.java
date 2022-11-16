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
    System.out.println(juegoModel.getJugadorActual().toString());
    System.out.println("Se encuentra en la casilla: " + juegoModel.getTablero().getCasilla(juegoModel.getJugadorActual().getCasillaActual()).toString()); // He puesto como público el getCasillaActual(), no sé si es correcto.
    if (juegoModel.finalDelJuego())
      System.out.println("Final del juego");
  }

  @Override
  public Respuesta comprar() {
/*    System.out.println("Si quiere comprar la casilla introduzca s, en otro caso pulse cualquier otra tecla ");
    Scanner entradaEscaner = new Scanner(System.in); //Creación de un objeto Scanner
    String entradaTeclado = entradaEscaner.nextLine(); //Invocamos un método sobre un objeto Scanner
    Respuesta r;
    if (entradaTeclado.equals("s")) {
      r = Respuesta.SI;
    } else {
      r = Respuesta.NO;
    }
    return r;
*/
    ArrayList<String> respuesta = new ArrayList<>();
    respuesta.add("NO");
    respuesta.add("SI");
    int opcion = menu(juegoModel.getTablero().getCasilla(juegoModel.getJugadorActual().getCasillaActual()).toString() + " ¿Quieres comprarla?", respuesta);
    return Respuesta.values()[opcion];
  }

  @Override
  public OperacionInmobiliaria elegirOperacion() {
    /*ArrayList<OperacionInmobiliaria> operaciones = new ArrayList<OperacionInmobiliaria>();
    ArrayList<String> operacionesString = new ArrayList<String>();
    for (OperacionInmobiliaria op : OperacionInmobiliaria.values()) {
      operaciones.add(op);
      operacionesString.add(op.toString());

    }
    int eleccion = menu("Operacion Inmobiliaria", operacionesString);
    return operaciones.get(eleccion);*/

    ArrayList<String> operacion = new ArrayList<>();
    operacion.add("CONSTRUIR_CASA");
    operacion.add("CONSTRUIR_HOTEL");
    operacion.add("TERMINAR");
    int opcion = menu("\n¿Qué número de gestión inmobiliara quieres realizar?",operacion);
    return OperacionInmobiliaria.values()[opcion];
  } // Comprobar.

  @Override
  public int elegirPropiedad() {
    ArrayList<Casilla> propiedades =  new ArrayList<Casilla>();
    propiedades = juegoModel.getJugadorActual().getPropiedades();
    ArrayList<String> propiedadesString = new ArrayList<String>();
    for (int i = 0; i < propiedades.size(); i++) {
      propiedadesString.add(propiedades.get(i).toString()); // He cambiado getPropiedades de protegido a publico, ya que si no no se puede acceder a las propiedades del jugador actual.
    }
    int eleccion = menu("Propiedades disponibles", propiedadesString);
    return eleccion;
  }

  @Override
  public void mostrarSiguienteOperacion(OperacionJuego operación) {
    System.out.println(operación.toString());
  }

  @Override
  public void mostrarEventos() {
    while(Diario.getInstance().eventosPendientes()) {
      System.out.println(Diario.getInstance().leerEvento());
    }
  }

}
