package controlador;

import modelo.Modelo;
import vista.Vista;


public class Controlador {
    
    private Modelo modelo;
    private Vista vista;
    
    public Controlador(Modelo m,Vista v) {
        modelo=m;
        vista=v;
        vista.setControlador(this);
        vista.recibeModelo(m);
    }
    
    public void añadeElemento(Integer i) {
        modelo.añadeElemento(i);
        vista.recibeModelo(modelo);
    }
    
    public void añadeElemento2(Integer i) {
        modelo.añadeElemento2(i);
        vista.recibeModelo(modelo);
    }
    
    public void quitaUno() {
        modelo.quitaUno();
        vista.recibeModelo(modelo);
    }
    
}
