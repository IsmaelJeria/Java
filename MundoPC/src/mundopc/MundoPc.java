package mundopc;

import com.gm.mundopc.*;

public class MundoPc {
    public static void main(String args[]){
        Raton r1 = new Raton("raton","LG");
        Teclado t1 = new Teclado("teclado","LG");
        Monitor m1 = new Monitor("LG",23);

        Raton r2 = new Raton("raton","LG");
        Teclado t2 = new Teclado("teclado","LG");
        Monitor m2 = new Monitor("LG",23);

        Raton r3 = new Raton("raton","LG");
        Teclado t3 = new Teclado("teclado","LG");
        Monitor m3 = new Monitor("LG",23);

        Computadora c1 = new Computadora("PC1",m1,t1,r1);
        Computadora c2 = new Computadora("PC2",m2,t2,r2);
        Computadora c3 = new Computadora("PC3",m3,t3,r3);

        Orden o1 = new Orden();

        o1.agregarComputadoras(c1);
        o1.agregarComputadoras(c2);
        o1.agregarComputadoras(c3);

        o1.mostrarOrden();

    }
}
