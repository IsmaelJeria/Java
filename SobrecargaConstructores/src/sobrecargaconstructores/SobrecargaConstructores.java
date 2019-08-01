package sobrecargaconstructores;

public class SobrecargaConstructores {
    public static void main(String args[]){
        Persona p1 = new Persona("ismi",30);
        System.out.println(p1);

        Persona p2 = new Persona("ale",29);
        System.out.println(p2);

        Empleado e1 = new Empleado("jeria",28, 5000);
        System.out.println(e1);
    }
}
