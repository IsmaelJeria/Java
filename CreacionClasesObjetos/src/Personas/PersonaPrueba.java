package Personas;

public class PersonaPrueba {

    public static void main(String argd[]){
        //creacion de un objeto
        Persona p1 = new Persona();
        //llamando un metodo del objeto creado
        System.out.println("valores por defecto del objeto persona");
        p1.desplegarNombre();

        //modificando valores

        p1.nombre="ismael";
        p1.apellidopaterno="jeria";
        p1.apellidomaterno="garrido";

        //llamando nuevamente el metodo desplegar nombre
        System.out.println("valores modificados del objeto persona");
        p1.desplegarNombre();

        //prueba de aritmetica

        Aritmetica suma1 = new Aritmetica();

        int resultado = suma1.sumar(2,3);
        System.out.println("valor de la suma:" +resultado);

    }


}
