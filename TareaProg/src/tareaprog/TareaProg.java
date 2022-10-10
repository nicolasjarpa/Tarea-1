
package tareaprog;

import java.util.ArrayList;
import java.util.Date;
import java.util.*;


class Articulo{
    private float peso;
    private String nombre;
    private String descripcion;
    private float precio;
    
    public Articulo(String l, String p, float elpepe, float sech){
        peso = elpepe;
        precio = sech;
        nombre = l;
        descripcion = p;
    }
    
    public float getPeso(){
        return peso;
    }
    
    public float getPrecio(){
        return precio;
    }
    
    public String toString(){
        return "Nombre Articulo:"+nombre+"\nDescripcion:"+descripcion+"\nPeso:"+peso+"\nPrecio:"+precio;
    }
}

class DetalleOrden{
    private Articulo Lucario;
    private int cantidad;
    
    public DetalleOrden(int c, Articulo cosa){
        cantidad = c;
        Lucario = cosa;
   }
    public float calcPrecio(){
  
        return Lucario.getPrecio()*cantidad;
    }
    
    public float calcPrecioSinIva(){

        return Lucario.getPrecio()/(119/100)*cantidad;
    }
        
    public float calcIVA(){
       return Lucario.getPrecio()*(19/100)*cantidad;
    }
    
    public float calcPeso(){
        
        return Lucario.getPeso()*cantidad;
    }
    
    public String toString(){
        return "Cantidad:"+cantidad+"\n"+Lucario.toString();
    }
}

class OrdenCompra{
    private Date fecha;
    private String estado = "Pendiente";
    private ArrayList <Pago> pe;
    private ArrayList <DetalleOrden> prp;
    private Cliente pedro;
    private Direccion direc;
    private DocTributario pelele;
    private Factura fact;
    private Boleta bole;
    
    public OrdenCompra(Date f){
        prp = new ArrayList <DetalleOrden>();
        this.fecha = f;
 
    }
    public void addArticulo(Articulo xd, int c){
            prp.add(new DetalleOrden(c,xd));
        }
    
   
   
    public float calcPreciosinIVA(){
        float prec=0;
        for(int i=0; i< prp.size(); i++){
            prec += prp.get(i).calcPrecioSinIva();
        }
        return prec;
    }
    
    public float calcIVA(){
        float preci=0;
        for(int i=0; i< prp.size(); i++){
            preci += prp.get(i).calcIVA();
        }
        return preci;
    }
    
    public float calcPrecio(){
       float precio=0;
        for(int i=0; i< prp.size(); i++){
            precio += prp.get(i).calcPrecio();
        }
        return precio;
    }
    
    public float calcPeso(){
        float precios=0;
        for(int i=0; i< prp.size(); i++){
            precios += prp.get(i).calcPeso();
        }
        return precios;
    }
    
    public void Efectivo(Efectivo e){
        pe.add(new Pago(e.getMonto(), e.getFecha()));
        float debt = calcPrecio()-e.getMonto();

        if(debt<0){
            e.calcDevolucion(debt);
            debt = 0;
        }
        
        if (debt==0){
            estado = "Completado";
        }
    }
    
    public void Tarjeta(Tarjeta t){
        pe.add(new Pago(t.getMonto(), t.getFecha()));
        float debt = calcPrecio()-t.getMonto();
        
         if (debt==0){
            estado = "Completado";
        }
    }
    
    public void Transferencia(Transferencia tr){
        pe.add(new Pago(tr.getMonto(),tr.getFecha()));
         float debt = calcPrecio()-tr.getMonto();
        
         if (debt==0){
            estado = "Completado";
        }
    }
        
    
    public void BoletaoFactura(String num, String rut, Date fecha, int caso){
        switch(caso){
            case 1:
                fact = new Factura(num,rut,fecha);
                bole = null;
            case 2:
                bole = new Boleta(num, rut, fecha);
                fact = null;
        }               
        
        
    }
     public void Documento(Cliente nico,Direccion a, int caso){
       pedro=nico;
       direc=a;
       BoletaoFactura(direc.getDireccion(), pedro.getRut(),fecha, caso);
    }
    public String toString(){
        String aux, aux2, aux3 = null, aux4, aux5 = null;
        if(fact!=null && bole == null){
        aux= fact.toString();
    }
        else{
        aux = bole.toString();
   }
        aux2="Documento:"+aux+"\n"+pedro.toString() + direc.toString() + "Estado:" + estado+"\n";
         for (int i = 0; i <prp.size(); i++) {
            aux3 = aux2 + prp.get(i).toString();
        }
        aux4 = aux3 + "Precio con Iva:" + calcPrecio() + "\n"+"Precio sin IVA:" + calcPreciosinIVA() + "\n"+"IVA:" + calcIVA();
        for (int i = 0; i < pe.size(); i++) {
            aux5 = aux4+"\n"+ "Pagos:"+ pe.get(i).toString();
        }
        
        return aux5;
>>>>>>> 34eaba1966032f40c497a93b07bec9e176ccf066
    }
    
}
class Cliente{
    private String nombre;
    private String rut;
    public Cliente(String n, String r){
        nombre = n;
        rut = r;
    }
    
    public String toString(){
        return "Nombre Cliente: "+nombre+"\n"+ "Rut: "+rut+"\n"+"Direccion:";
    }
    public String getNombre(){
        return nombre;
    }
    
    public String getRut(){
        return rut;
    }
    
}

class Direccion{

    private String direccion;
    
    public Direccion(String d){
        direccion = d;
    }
    
    public String getDireccion(){
        return direccion;
    }
    public String toString(){
        return "Direccion:"+getDireccion()+"\n";
    }
}

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

class Boleta extends DocTributario{
    
    public Boleta(String n, String m, Date k){
        super(n, m, k);
    }
} 

class Factura extends DocTributario{
    
    public Factura(String n, String m, Date k){
        super(n, m , k);
    }
} 

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
        return "monto:"+getMonto()+"\nFecha:"+getFecha();
    }
}

class Efectivo extends Pago{

    
    public Efectivo(float k, Date s){
        
        super(k, s);
    }
    
    public float calcDevolucion(float paga){
        if(paga>super.getMonto()){
            paga = paga - super.getMonto();
        }
        
        else{
            return 0;
        }
        
        return paga;
    }
}

class Transferencia extends Pago{
    private String banco;
    private String numCuenta;
    
    public Transferencia(float pe, Date k,String b, String nu){
        super(pe, k);
        banco = b;
        numCuenta = nu;
        
    } 
    
    public String getBanco(){
        return banco;
    }
    
    public String getnumCuenta(){
        return numCuenta;
    }
}

class Tarjeta extends Pago{
    private String tipo;
    private String numTransaccion;
    
    public Tarjeta(float sh, Date d,String t, String nt){
        super(sh, d);
        tipo = t;
        numTransaccion = nt;
    }
    
    public String getTipo(){
        return tipo;
    }
    
    public String getnumTransaccion(){
        return numTransaccion;
    }
}






public class TareaProg {


    public static void main(String[] args) {
        Date fecha= new Date(122,5,6,10,3,4);
        Direccion casa= new Direccion("av los autos");
        Cliente pepe =  new Cliente("John Cena", "20.879.273-8");
        Articulo a = new Articulo("Elpepe", "Es el pepe", 500, 69420);
        DetalleOrden e = new DetalleOrden(69, a);
        System.out.println(fecha);
        System.out.println(pepe.toString());
        System.out.println(e.toString());

    }
    
}