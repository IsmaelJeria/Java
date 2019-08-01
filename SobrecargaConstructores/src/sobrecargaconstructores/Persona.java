package sobrecargaconstructores;

public class Persona {

    private int idPersona;
    private String nombre;
    private int edad;
    private static int contadorPersonas;

    /*constructor sin argumentos y privado
    asigna el isPersona
    */
    private Persona(){
        this.idPersona = ++contadorPersonas;
    }

    //constructor completo sobrecargado
    public Persona(String nombre, int edad){
        //el this hace la llamada al construcotr vacio que es privado
        this();
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +"Persona{ idPersona " + idPersona + " nombre=" + nombre + " edad=" + edad +'}';
    }
}
