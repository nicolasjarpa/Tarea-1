
package tareaprog;

import java.util.Date;

class Boleta extends DocTributario{
    
    public Boleta(String n, String m, Date k){
        super(n, m, k);
    }
    
    public String toString(){
        return "Pago Boleta";
    }
} 

class Factura extends DocTributario{
    
    public Factura(String n, String m, Date k){
        super(n, m , k);
    }
    
    public String toString(){
        return "Pago Factura";
    }
} 
