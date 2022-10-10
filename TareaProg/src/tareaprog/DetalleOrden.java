
package tareaprog;

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

        return Lucario.getPrecio()/(1.19f)*cantidad;
    }
        
    public float calcIVA(){
       return Lucario.getPrecio()*(0.19f)*cantidad;
    }
    
    public float calcPeso(){
        
        return Lucario.getPeso()*cantidad;
    }
    
    public String toString(){
        return "Cantidad:"+cantidad+"\n"+Lucario.toString();
    }
}
