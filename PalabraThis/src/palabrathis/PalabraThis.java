package palabrathis;

public class PalabraThis {

    public static void main(String[] args){

        Persona p = new Persona ("Juan");

    }
}

class Persona{

    String nombre; //atributo de la clase
    Persona (String nombre){
        this.nombre = nombre; //this es el objeto persona actual
        //imprimimos el objeto persona
        Imprimir i = new Imprimir();
        i.Imprimir(this); //this es el objeto persona actual

    }

}

class Imprimir{

    public void Imprimir(Object o){
        System.out.println("imprimir parametro: "+o);//el parametro es el objeto persona
        System.out.println("imprimir objeto actual (this): "+this);//this es el objeto imprimir
    }

}