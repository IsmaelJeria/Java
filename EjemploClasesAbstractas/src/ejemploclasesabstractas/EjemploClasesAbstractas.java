package ejemploclasesabstractas;
import abstracto.domain.*;

public class EjemploClasesAbstractas {
    public static void main( String[] args ){
        //creacion de objetos
        FiguraGeometrica rectangulo = new Rectangulo("Rectangulo");
        FiguraGeometrica circulo = new Circulo("Circulo");
        FiguraGeometrica triangulo = new Triangulo("Triangulo");

        System.out.println(rectangulo);
        rectangulo.dibujar();
        System.out.println(" ");

        System.out.println(circulo);
        circulo.dibujar();
        System.out.println(" ");

        System.out.println(triangulo);
        triangulo.dibujar();
        System.out.println(" ");


    }
}
