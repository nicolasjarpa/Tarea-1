package tareaprog;

import java.util.ArrayList;
import java.util.Date;
import java.util.*;

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
        pe = new ArrayList <Pago>();
 
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
        }
        
        if (debt==0){
            estado = "Completado";
        }
        
        e.getMonto();
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
        aux4 = aux3 + "\nPrecio con Iva:" + calcPrecio() + "\n"+"Precio sin IVA:" + calcPreciosinIVA() + "\n"+"IVA:" + calcIVA();
        for (int i = 0; i < pe.size(); i++) {
            aux5 = aux4+"\n"+ "Pagos:"+ pe.get(i).toString();
        }
        
        return aux5;
    }
    
    
    
}

public class TareaProg {


    public static void main(String[] args) {
        Date fecha= new Date(122,5,6,10,3,4);
        Cliente pepe =  new Cliente("John Cena", "20.879.273-8");
        Articulo a = new Articulo("Elpepe", "Es el pepe", 500, 69420);
        DetalleOrden e = new DetalleOrden(69, a);
        Direccion se = new Direccion("Noxus 879");
        Boleta k = new Boleta("John Cena", "20.879.273-8", fecha);
        OrdenCompra el = new OrdenCompra(fecha);
        Efectivo po = new Efectivo(69421f, fecha);
        Transferencia pp = new Transferencia(69420, fecha, "Banco Estao", "696969");
        Pago pago = new Pago(69421f, fecha);
        el.BoletaoFactura("101204394", pepe.getRut(), fecha, 1);
        el.Documento(pepe, se , 1);
        el.Transferencia(pp);
        el.addArticulo(a, 1);
        el.calcIVA();
        el.calcPeso();
        el.calcPrecio();
        el.calcPreciosinIVA();
        System.out.println(el.toString());
    }
    
}
