package manejoexcepciones1;
import domain.*;

public class ManejoExcepcionesArg {

    public static void main(String[] args) throws OperationException {
        try {
            int op1 = Integer.parseInt(args[0]);
            int op2 = Integer.parseInt(args[1]);
            Division division = new Division(op1, op2);
            division.visualizarOperacion();
        } catch (ArrayIndexOutOfBoundsException aie) {
            System.out.print("hubo un error: ");
            System.out.println("ocurrio un error al acceder al elemento fuera de rango");
            aie.printStackTrace();
        } catch (NumberFormatException nfe) {
            System.out.print("hubo un error: ");
            System.out.println("uno de los argumentos no es entero");
            nfe.printStackTrace();
        } catch (OperationException oe) {
            System.out.println("error error");
            oe.printStackTrace();
        } finally {
            System.out.println("se terminaron de revisar als excepciones");
        }
    }

}
