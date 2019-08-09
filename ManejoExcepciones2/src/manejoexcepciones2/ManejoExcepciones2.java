package manejoexcepciones2;

import datos.*;
import excepciones.*;

public class ManejoExcepciones2 {
    public static void main(String[] args){

        AccesoDatos accesoDatos = new ImplementacionMySql();
        //ponemos el simular error en true
        accesoDatos.simularError(true);
        ejecutar(accesoDatos, "listar");

        //cambiamos el estado de error a false
        accesoDatos.simularError(false);
        ejecutar(accesoDatos, "insertar");

    }

    private static void ejecutar(AccesoDatos accesoDatos, String accion){
        if("listar".equals(accion)){
            try {
                accesoDatos.listar();
            } catch (LecturaDatosEx le) { //si se procesan varias excepciones van desde la de menor jerarquia hasla la de mayor jerarquia
                System.out.println("procesa el error de lectura de datos especificado");
            } catch (AccesoDatosEx ae) {
                System.out.println("procesa el error de acceso de datos especificado");
            } catch (Exception ex) {
                System.out.println("Error general");
            } finally {
                System.out.println("aca se pueden cerrar los recursos que se deben cerrar");
            }
        } else if ("insertar".equals(accion)){
            try {
                accesoDatos.insertar();
            } catch (EscrituraDatosEx ee) { //si se procesan varias excepciones van desde la de menor jerarquia hasla la de mayor jerarquia
                System.out.println("procesa el error de excritura de datos especificado");
            } catch (AccesoDatosEx ae) {
                System.out.println("procesa el error de acceso de datos especificado");
            } catch (Exception ex) {
                System.out.println("Error general");
            } finally {
                System.out.println("aca se pueden cerrar los recursos que se deben cerrar");
            }
        } else {
            System.out.println("accion no conocida");
        }


    }

}
