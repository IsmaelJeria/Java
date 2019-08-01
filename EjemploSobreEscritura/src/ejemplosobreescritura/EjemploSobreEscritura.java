package ejemplosobreescritura;

public class EjemploSobreEscritura {
    public static void main(String[] args){
        Empleado empleado = new Empleado("juan",1000);
        System.out.println(empleado.obtenerDetalles());

        Gerente gerente = new Gerente("juan",1000, "casa");
        System.out.println(gerente.obtenerDetalles());
    }
}
