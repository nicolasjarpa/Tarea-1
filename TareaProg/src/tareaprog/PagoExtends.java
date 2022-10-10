
package tareaprog;

import java.util.Date;

class Efectivo extends Pago{
    private float pagao;
    public Efectivo(float k, Date s){
        
        super(k, s);
    }
    
    public float calcDevolucion(float paga){
        if(paga>=super.getMonto()){
            paga = paga - super.getMonto();
            pagao = paga;
            return paga;
        }
        
        else{
            pagao = 0;
            return 0;
        }

    }
    
    public String toStringEfectivo(){
        return "Su Vuelto es:"+pagao;
    }
}

class Transferencia extends Pago{
    private String banco;
    private String numCuenta;
    
    public Transferencia(float k, Date s,String b, String nu){
        super(k, s);
        banco = b;
        numCuenta = nu;
        
    } 
    
    public String getBanco(){
        return banco;
    }
    
    public String getnumCuenta(){
        return numCuenta;
    }
    
    public String toStringTra(){
        return "Del Banco:"+banco+"\nDe la Cuenta:"+numCuenta;
    }
}

class Tarjeta extends Pago{
    private String tipo;
    private String numTransaccion;
    
    public Tarjeta(float k, Date s,String t, String nt){
        super(k, s);
        tipo = t;
        numTransaccion = nt;
    }
    
    public String getTipo(){
        return tipo;
    }
    
    public String getnumTransaccion(){
        return numTransaccion;
    }
    
    public String toStringTarj(){
        return "Tipo de tarjeta:"+tipo+"\nNúmero de Transacción:"+numTransaccion;
        
    }
}
