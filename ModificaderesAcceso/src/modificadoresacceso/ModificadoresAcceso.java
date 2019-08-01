package modificadoresacceso;

import paquete1.Clase2;
import paquete2.*;

public class ModificadoresAcceso {
    public static void main(String[] args){
        //pruba de acceso a clase 1 desde otras clases

        System.out.println("acceso desde clase 2: mismo paquete");
        Clase2 c2 = new Clase2();
        c2.pruebaDesdeClase2();

        System.out.println("acceso desde clase 3: diferente paquete pero es subclase");
        new Clase3().pruebaDesdeClase3();

        System.out.println("acceso desde clase 4: diferente paquete y no es subclase");
        new Clase4().pruebaDesdeClase4();
    }
}
