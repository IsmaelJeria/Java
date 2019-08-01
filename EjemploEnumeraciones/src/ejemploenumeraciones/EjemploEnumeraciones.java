package ejemploenumeraciones;

public class EjemploEnumeraciones {
    public static void main(String[] args){
        //valores de la enumeracion
        System.out.println("valor 1: "+ Dias.LUNES);
        indicarDias(Dias.DOMINGO);

        //utilizamos la enumeracion de paises
        System.out.println("paises del continente " + Continentes.AMERICA + ": " + Continentes.AMERICA.getPaises());
    }

    public static void indicarDias(Dias dias){
        switch (dias){
            case LUNES:
                System.out.println("dia 1");
                break;
            case MARTES:
                System.out.println("dia 2");
                break;
            case MIERCOLES:
                System.out.println("dia 3");
                break;
            case JUEVES:
                System.out.println("dia 4");
                break;
            case VIERNES:
                System.out.println("dia 5");
                break;
            case SABADO:
                System.out.println("dia 6");
                break;
            case DOMINGO:
                System.out.println("dia 7");
                break;
            default:
                System.out.println("Dias no autorizado");

        }
    }
}
