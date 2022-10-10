
package tareaprog;

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
        return "Nombre:"+nombre+"\nDescripcion:"+descripcion+"\nPeso:"+peso+"\nPrecio:"+precio;
    }
}
