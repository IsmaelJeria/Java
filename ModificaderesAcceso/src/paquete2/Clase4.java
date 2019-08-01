package paquete2;
import paquete1.Clase1;
public class Clase4 {
    public Clase4(){
        //constructor protegido, restringido al no ser una subclase
        //super(1,2);
        //acceso package y al estar fuera de paquete esta restringido
        //super(1,2,3);
        //acceso privado es denegado

    }

    public void pruebaDesdeClase4(){
        Clase1 c1 = new Clase1();
        System.out.println(" ");
        System.out.println("atributo publico" + c1.atrPublico);
        System.out.println("atributo protegido, no se puede acceder a este al no ser una subclase del paquete protegido");
        System.out.println("atributo default, no se puede acceder desde un paquete externo");
        System.out.println("atributo privado se le denega el acceso");

        //constructor publico
        new Clase1();
        //los demas constructores estan restringidos
        System.out.println(" ");
        System.out.println("metodo publico" + c1.metodoPublico());
        System.out.println("metodo protegido, no se puede acceder a este al no ser una subclase del paquete protegido");
        System.out.println("metodo default, no se puede acceder desde un paquete externo");
        System.out.println("metodo privado se le denega el acceso");


    }
}
