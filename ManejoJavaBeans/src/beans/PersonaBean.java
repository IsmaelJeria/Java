package beans;
import java.io.Serializable;

//1. implementa el serializable de java.io
public class PersonaBean implements Serializable{

    //2. las propiedades deben de ser privadas
    private String nombre;
    private int edad;

    //3. siempre tiene que tener un constructor vacio
    public PersonaBean(){}

    //4. constructor del java benas, no es requerido
    public PersonaBean(String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
    }

    //5. para acceder a las propiedades es necesario utilizar los get y set de cada propiedad
    //solo es necesario implementarlas si es que se requieren
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
