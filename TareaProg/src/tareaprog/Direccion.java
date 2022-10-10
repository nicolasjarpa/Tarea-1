
package tareaprog;

class Direccion{

    private String direccion;
    
    public Direccion(String d){
        direccion = d;
    }
    
    public String getDireccion(){
        return direccion;
    }
    public String toString(){
        return "\nDireccion:"+getDireccion()+"\n";
    }
}
