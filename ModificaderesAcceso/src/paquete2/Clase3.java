package paquete2;
import paquete1.Clase1;
public class Clase3 extends Clase1{

    public Clase3(){
        //constructor protegido, al ser de una subclase puede accedes aunque este en otro paquete
        super(1,2);
        //acceso package, y al estar fuera de paquete esta restringido
        //super(1,2,3)
        //acceso privado tambien esta denegado
    }


    public void pruebaDesdeClase3(){
        Clase1 c1 = new Clase1();
        System.out.println(" ");
        System.out.println("atributo publico: "+ c1.atrPublico + "o heredado: " + atrPublico);
        System.out.println("atributo protegido (heredado): "+ atrProtegido);
        System.out.println("atributo default no se puede acceder desde un paquete externo ");
        System.out.println("atributo privado se le denega el acceso ");

        //constructor publico
        new Clase1();
        //los demas constructores no se pueden probar asi, sino desde el constructor
        //de esta clase, ya que esta es una subclase en otro paquete

        System.out.println(" ");
        System.out.println("metodo publico" + c1.atrPublico);
        System.out.println("metodo protegido(heredado)" + metodoProtegido());
        System.out.println("metodo default: no se puede desde un paquete externo ");
        System.out.println("metodo privado acceso denegado");
    }
}
