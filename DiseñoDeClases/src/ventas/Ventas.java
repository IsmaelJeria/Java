package ventas;

import gm.com.ventas.*;

import gm.com.ventas.Orden;
import gm.com.ventas.Producto;

public class Ventas {
    public static void main(String args[]){
        Orden orden1 = new Orden();
        Producto producto1 = new Producto("arroz1", 5000);
        Producto producto2 = new Producto("arroz2", 5000);
        Producto producto3 = new Producto("arroz3", 5000);
        Producto producto4 = new Producto("arroz4", 5000);
        Producto producto5 = new Producto("arroz5", 5000);
        orden1.agregarProducto(producto1);
        orden1.agregarProducto(producto2);
        orden1.agregarProducto(producto3);
        orden1.agregarProducto(producto4);
        orden1.agregarProducto(producto5);

        orden1.mostrarOrden();
    }
}
