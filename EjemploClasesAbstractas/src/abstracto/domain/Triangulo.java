package abstracto.domain;

public class Triangulo extends FiguraGeometrica{

    public Triangulo( String figuraGeometrica){
        super(figuraGeometrica);
    }

    public void dibujar() {
        System.out.println("aqui deberia dibujar un: " +this.getClass().getSimpleName());
    }
}
