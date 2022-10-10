
package tareaprog;


class Cliente{
    private String nombre;
    private String rut;
    private Direccion hoy;
    public Cliente(String n, String r){
        nombre = n;
        rut = r;
    }
    
    public String toString(){
        return "Nombre: "+nombre+", Rut: "+rut;
    }
    
    public void Direccion(Direccion ca){
        hoy=ca;
    }
    public String getNombre(){
        return nombre;
    }
    
    public String getRut(){
        return rut;
    }
}
