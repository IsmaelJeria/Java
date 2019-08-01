package com.gm.mundopc;

public class DispositivoEntrada {
    private String tipoEntrada;
    private String marca;
    private static int contadorEntradas;
    private final int idEntrada;

    public DispositivoEntrada(){
        this.idEntrada = ++contadorEntradas;
    }

    public DispositivoEntrada(String tipoEntrada, String marca){
        this();
        this.tipoEntrada = tipoEntrada;
        this.marca = marca;
    }

    public void setTipoEntrada(String tipoEntrada){
        this.tipoEntrada = tipoEntrada;
    }

    public void setMarca (String marca){
        this.marca = marca;
    }

    public String getTipoEntrada(){
        return this.tipoEntrada;
    }

    public String getMarca(){
        return this.marca;
    }

    @Override
    public String toString() {
        //return super.toString();
        return "Dispositivo de entrada: {idEntrada: " + this.idEntrada + " tipoEntrada: " + this.tipoEntrada + " marca: " + this.marca;
    }

}
