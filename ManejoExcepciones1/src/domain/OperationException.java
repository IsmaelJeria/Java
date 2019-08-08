package domain;

public class OperationException extends Exception{

    public OperationException(String mensaje){
        //inicializamos el mensaje de error de la clase padre
        super(mensaje);
    }

}
