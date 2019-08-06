package manejointerfaces;

import datos.*;

public class ManejoInterfaces {
    public static void main( String[] args ){

        //utilizamos la interface que hace referencia al objeto donde se implementan los meotods de la interface

        AccesoDatos accesoDatos = new ImplementacionOracle();
        ejecutar(accesoDatos,"listar");

        accesoDatos = new ImplementacionMySql();
        ejecutar(accesoDatos,"insertar");

        /*
        ImplementacionOracle implementacionOracle = new ImplementacionOracle();

        implementacionOracle.insertar();
        implementacionOracle.listar();
        System.out.println(implementacionOracle.MAX_REGISTROS);

        ImplementacionMySql implementacionMySql = new ImplementacionMySql();
        implementacionMySql.insertar();
        implementacionMySql.listar();
        System.out.println(implementacionMySql.MAX_REGISTROS);
        */
    }

    public static void ejecutar(AccesoDatos datos, String accion){
        if("listar".equals(accion)){
            datos.listar();
        } else if("insertar".equals(accion)){
            datos.insertar();
        } else {
            System.out.println("accion desconocida");
        }

    }
}
