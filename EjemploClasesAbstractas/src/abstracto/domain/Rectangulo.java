package abstracto.domain;

public class Rectangulo extends FiguraGeometrica{

    public Rectangulo( String figuraGeometrica){
        super(figuraGeometrica);
    }

    public void dibujar() {
        System.out.println("aqui deberia dibujar un: " +this.getClass().getSimpleName());
    }
}
