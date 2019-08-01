package encapsulamiento;

public class Encapsulamiento {

        public static void main(String args[]){

            String nombre;
            String apellido;
            Persona p1 = new Persona("ismael","jeria",true);

            System.out.println(p1.getNombre());
            System.out.println(p1.getApellido());
            System.out.println(p1);
            System.out.println(Persona.getContadorPersonas());
            p1.setApellido("garrido");
            System.out.println(p1.getNombre());
            System.out.println(p1.getApellido());
            System.out.println(p1);

            Persona p2 = new Persona("ismaelin","jeriasadsad",true);

            System.out.println(p2);
            System.out.println(Persona.getContadorPersonas());
        }

}
