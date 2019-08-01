package com.gm.mundopc;

public class Computadora {
    private final int idComputadora;
    private String nombre;
    private Monitor monitor;
    private Teclado teclado;
    private Raton raton;
    private static int contadorComputadoras;

    private Computadora(){
        this.idComputadora = ++contadorComputadoras;
    }

    public Computadora(String nombre, Monitor monitor, Teclado teclado, Raton raton){
        this();
        this.nombre = nombre;
        this.monitor = monitor;
        this.teclado = teclado;
        this.raton = raton;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setMonitor(Monitor monitor){
        this.monitor = monitor;
    }

    public void setTeclado(Teclado teclado){
        this.teclado = teclado;
    }

    public void setRaton (Raton raton){
        this.raton = raton;
    }

    public String getNombre(){
        return this.nombre;
    }

    public Monitor getMonitor(){
        return this.monitor;
    }

    public Teclado getTeclado(){
        return this.teclado;
    }

    public Raton getRaton(){
        return this.raton;
    }

    @Override
    public String toString(){
        return "Computadora: {" + "idComputadora: " + this.idComputadora + " Nombre: " + this.nombre + " " +this.monitor+" " + this.teclado +" " + this.raton + " }";
    }
}
