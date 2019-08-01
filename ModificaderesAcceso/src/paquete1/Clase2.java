package paquete1;

public class Clase2 {
    public Clase2(){
        //prueba constructores
        System.out.println("");
        //constructor publico
        new Clase1(1);
        //constructor protegido
        new Clase1(1,2);
        //construcotr default o package
        new Clase1(1,2,3);
        //constructor private //es un cosntructor privado
        //new Clase1(1,2,3,4);
    }

    public void pruebaDesdeClase2(){
        //acceso a clase 1 desde clase 2
        Clase1 c1 = new Clase1();
        System.out.println(" ");
        System.out.println("Atributo publico: " + c1.atrPublico);
        System.out.println("Atributo protegido: " + c1.atrProtegido);
        System.out.println("atributo default" + c1.atrPaquete);
        System.out.println("atributo privado acceso denegado");

        System.out.println(" ");
        System.out.println("metodo publico: " + c1.metodoPublico());
        System.out.println("metodo protegido: " + c1.metodoProtegido());
        System.out.println("metodo default" + c1.metodoPaquete());
        System.out.println("metodo privado acceso denegado");


    }
}

