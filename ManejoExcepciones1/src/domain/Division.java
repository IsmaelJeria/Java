package domain;

public class Division {

    private int numerador;
    private int denominador;

    public Division(int numerador, int denominador)throws OperationException {

        if (denominador == 0){
            //tambien existen excepciones genericas pero nosotros creamos la nuestra
            //throw new IllegalArgumentException("Denominador igual a cero");
            throw new OperationException("Denominador igual a cero");
        }
        this.numerador = numerador;
        this.denominador = denominador;

    }

    public void visualizarOperacion(){
        System.out.println("resultado " + numerador/denominador);
    }
}
