package Aritmetica;

public class Aritmetica {

    //atributos de la clase
    int a,b;

    //constructor vacio
    Aritmetica(){}

    //constructor con 2 argumentos

    Aritmetica(int arg1, int arg2){
      a=arg1;
      b=arg2;
    }

    //este metodo toma valores nuevos
    int sumar(int a, int b){
        this.a = this.b;
        return a+b;
    }

    int sumar(){
        return a+b;
    }
}
