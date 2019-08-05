package ejemploconversionobjetos;

public class EjemploConversionObjetos {
    public static void main(String[] args){

        //1. creamos un tipo de la mas alta jerarquia
        Empleado empleado;

        //2. asignamos una referencia a un objeto de menor jerarquia
        //esto es upcasting, no hay necesidad de una notacion especial
//        empleado = new Escritor("ismael", 5000, TipoEscritura.CLASICO);
        empleado = new Gerente("ismael", 5000, "mi casa");

        //como el objeto es de tipo empleado solo se pueden llamar esos metodos,
        //es necesario hacer un casting para acceder a los demas metodos

        imprimirDetalle(empleado);

        /*
        //metodo generico
        System.out.println(empleado.obtenerDetalle());

        // de la forma corta
        System.out.println(((Escritor)empleado).getTipoEscrituraEnTexto());

        //asignando a una nueva variable

        Escritor escritor =
        */
    }

    public static void imprimirDetalle(Empleado empleado) {

        //primero una impresion generica
        System.out.println("\nobtener detalle" + empleado.obtenerDetalle());

        //imprimimos el resto de los detalles  para verificar que funciona el casting
        if (empleado instanceof Escritor) {

            String texto = ((Escritor)empleado).getTipoEscrituraEnTexto();
            System.out.println(", tipo de escritura: " + texto);
        } else if ( empleado instanceof Gerente) {
            Gerente gerente = (Gerente) empleado;
            String depto = gerente.getDepartamento();
            System.out.println(", departamento: " + depto);
        }

    }
}
