package claseobjet;

public class ClaseObjet {
    public static void main( String[] args ){

        Empleado emp1 = new Empleado("ismael", 1000);
        Empleado emp2 = new Empleado("ismael", 1000);

        compararObjetos(emp1, emp2);
    }

    public static void compararObjetos(Empleado empleado1, Empleado empleado2){

        //imprimios los tostring de los objetos
        System.out.println("empleado1: " + empleado1);
        System.out.println("empleado2: " + empleado2);

        //verificamos la direccion de memoria
        if(empleado1 == empleado2) {
            System.out.println("las direcciones de memoria son la misma");
        } else {
            System.out.println("las direcciones de memoria son distintas");
        }

        //se verifica si los objetos son iguales
        if(empleado1.equals(empleado2)) {
            System.out.println("los objetos son iguales");
        } else {
            System.out.println("los objetos son distintos");
        }

        // de verifica que los hash sean iguales

        if(empleado1.hashCode() == empleado2.hashCode()) {
            System.out.println("los hash son iguales");
        } else {
            System.out.println("los hash son distintos");
        }


    }

}
