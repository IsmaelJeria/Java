package datos;

public class ImplementacionOracle implements AccesoDatos {

    @Override
    public void insertar() {
        System.out.println("insertar desde ImplementacionOracle");
    }

    @Override
    public void listar() {
        System.out.println("listar desde ImplementacionOracle");
    }
}
