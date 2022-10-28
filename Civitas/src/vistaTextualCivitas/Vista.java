/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.vistaTextualCivitas;


import src.civitas.OperacionInmobiliaria;
import src.civitas.OperacionJuego;
import src.controladorCivitas.Respuesta;

public interface Vista {

    public void actualiza();

    public void pausa();

    public Respuesta comprar();

    public OperacionInmobiliaria elegirOperacion();

    public int elegirPropiedad();

    public void mostrarSiguienteOperacion(OperacionJuego operación);

    public void mostrarEventos();

}
