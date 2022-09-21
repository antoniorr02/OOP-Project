package civitas;

import java.util.ArrayList;

public class TempMazoSorpresas {
    
    private ArrayList<Sorpresa> sorpresas;
    private  boolean barajada;
    private int usadas;
    private boolean debug;

    private void init(){
        sorpresas = null;
        barajada = false;
        usadas = 0;
    }
    
    protected TempMazoSorpresas(boolean d){ //comprobar lo del diario
       debug = d;
        if(debug)
            return init();
        }
    }

    protected TempMazoSorpresas(){
        debug = false;
        init();
    }

    void alMazo(Sorpresa s){
        
    }

    Sorpresa siguiente(){

    }
}
