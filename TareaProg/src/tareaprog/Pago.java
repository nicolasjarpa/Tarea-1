
package tareaprog;

import java.util.Date;

class Pago{
    private float monto;
    private Date fecha;
    
    public Pago(float m, Date f){
        monto = m;
        fecha = f;
    }
    
    public float getMonto(){
        return monto;
    }
    
    public Date getFecha(){
        return fecha;
    }
    
    public String toString(){
        return "\n"+getMonto();
    }
}
