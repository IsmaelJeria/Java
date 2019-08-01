package encapsulamiento;

public class Persona {

    //atributos privados
    private String nombre;
    private String apellido;
    private boolean borrado;
    private int idPersona;
    private static int contadorPersonas;


    //constructor vacio
    public Persona(){}

    //constructor con argumentos
    public Persona(String nombre, String apellido, boolean borrado){
        contadorPersonas++;
        this.nombre = nombre;
        this.apellido = apellido;
        this.borrado = borrado;
        idPersona = contadorPersonas;
    }


    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getApellido(){
        return this.apellido;
    }

    public void setApellido(String apellido){
        this.apellido = apellido;
    }

    public boolean isBorrado(){ return borrado; }

    public void setBorrado(boolean borrado){ this.borrado = borrado;}

    //metodo que imprime el estado del objeto

    @Override
    public String toString() {
        //return super.toString();
        return "Persona{ " + " nombre=" + nombre + " apellido=" + apellido +" borrado=" + borrado + '}';
    }

    public static int getContadorPersonas(){
        return contadorPersonas;
    }

}
