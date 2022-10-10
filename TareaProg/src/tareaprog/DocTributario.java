
package tareaprog;

import java.util.Date;

class DocTributario{
    private String numero;
    private String rut;
    private Date fecha;
    
    public DocTributario(String n, String r, Date f){
        numero = n;
        rut = r;
        fecha = f;
    }
    
    public String getNumero(){
        return numero;
    }
    
    public String getRut(){
        return rut;
    }
    
    public Date getFecha(){
        return fecha;
    }
    
    public String toString(){
        return "Numero:"+getNumero()+"\n"+"Rut:"+getRut()+"\n"+"\nFecha:"+getFecha()+"\n";
    }
}