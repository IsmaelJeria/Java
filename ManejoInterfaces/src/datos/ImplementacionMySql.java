package datos;

public class ImplementacionMySql implements AccesoDatos{

    @Override
    public void insertar() {
        System.out.println("insertar desde ImplementacionMySql");
    }

    @Override
    public void listar() {
        System.out.println("listar desde ImplementacionMySql");
    }
}

