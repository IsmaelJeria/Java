package abstracto.domain;

public class Circulo extends FiguraGeometrica{

    public Circulo( String figuraGeometrica){
        super(figuraGeometrica);
    }

    public void dibujar() {
        System.out.println("aqui deberia dibujar un: " +this.getClass().getSimpleName());
    }
}
