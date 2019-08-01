package com.gm.mundopc;

public class Orden {
    private final int idOrden;
    private Computadora Computadoras[];
    private static int contadorComputadoras;
    private static int contadorOrden;
    private int maxComputadoras = 3;

    public Orden(){
        idOrden = ++contadorOrden;
        Computadoras = new Computadora[maxComputadoras];
    }

    public void agregarComputadoras(Computadora computadora){
        //agregar computadoras segun el limite establecido
        if(contadorComputadoras < maxComputadoras){
            Computadoras[contadorComputadoras++] = computadora;
        }else {
            System.out.println("se ha superado el limite maximo de computadoras " + (contadorComputadoras));
        }
    }

    public void mostrarOrden(){
        System.out.println("la cantidad de computadoras es: " + (contadorComputadoras) );
        for (int i = 0 ; i < contadorComputadoras; i++){
            System.out.println(Computadoras[i].getNombre() + Computadoras[i].getMonitor());
        }
    }
}
