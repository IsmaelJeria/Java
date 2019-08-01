
public class ManejoVariables {
    public static void main(String[] args) {
        //declaracion de boleano
        boolean bool1;
        //inicializacion
        bool1 = true;
        //declaracion e inicializacion
        boolean bool2 = false;
        System.out.println("valor de bool1: " +bool1);
        System.out.println("valor de bool2: " +bool2);
        System.out.println("");

        //variable byte
        byte b1 =10;
        //literal en hexadecimal
        byte b2 = 0xa;
        System.out.println("valor de byte1: " +b1);
        System.out.println("valor de byte2: " +b2);
        System.out.println("");

        //variable short
        short s1 = 2;
        System.out.println("valor de short: " +s1);
        System.out.println("");

        /*
        * Variable char, declaracion e inicializacion de una sola linea
        * la primera declaracion en es unicode
        */

        char ch1=65, ch2 = 'A';
        System.out.println("valor de char1: " +ch1);
        System.out.println("valor de char2: " +ch2);
        System.out.println("");

        //Variables enteras
        int decimal = 100;
        int octal = 0144; //el octal se antepone un cero
        int hexadecimal = 0x64;  // el hexa comienza con un 0x
        System.out.println("valor de decimal: " +decimal);
        System.out.println("valor de octal: " +octal);
        System.out.println("valor de hexa: " +hexadecimal);
        System.out.println("");

        //variables long
        long long1 = 10, long2 = 20L;
        System.out.println("valor de long1: " +long1);
        System.out.println("valor de long2: " +long2);
        System.out.println("");

        //Variable flotante
        float f1=15, f2=22.3F;
        System.out.println("valor de f1: " +f1);
        System.out.println("valor de f2: " +f2);
        System.out.println("");

        //variables double
        double d1=11.0, d2=30.15D;
        System.out.println("valor de d1: " +d1);
        System.out.println("valor de d2: " +d2);
        System.out.println("");
    }
}
