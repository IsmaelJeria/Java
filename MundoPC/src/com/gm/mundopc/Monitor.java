package com.gm.mundopc;

public class Monitor {
    private final int idMonitor;
    private String marca;
    private double tamaño;
    private static int contadoMonitores;

    private Monitor(){
        this.idMonitor = ++contadoMonitores;
    }

    public Monitor(String marca, double tamaño){
        this();
        this.marca = marca;
        this.tamaño = tamaño;
    }

    public void setMarca(String marca){
        this.marca = marca;
    }

    public void setTamaño(double tamaño){
        this.tamaño = tamaño;
    }

    public String getMarca(){
        return this.marca;
    }

    public double getTamaño(){
        return this.tamaño;
    }

    @Override
    public String toString(){
        return "monitor: " + "{idMonitor: " + this.idMonitor + " marca: " + this.marca + " tamaño: " + this.tamaño +" }";
    }
}
