package gm.com.ventas;

public class Orden {
    private final int idOrden;
    private final Producto productos[];
    private static int contadorOrdenes;
    private int contadorProductos;
    public static final int maxProductos = 10;

    public Orden(){
        this.idOrden = ++contadorOrdenes;
        productos = new Producto[maxProductos];
    }

    public void agregarProducto(Producto producto){
        //aca se agregaran los productos si es que no superan el maximo de productos
        if(contadorProductos < maxProductos){
            productos[contadorProductos++] = producto;
        }else {
            System.out.println("se ha superado el limite de productos de " + maxProductos);
        }
    }

    public double calcularTotal(){
        double total = 0;
        for(int i = 0; i < contadorProductos; i++){
            total += productos[i].getPrecio();
        }
        return total;
    }

    public void mostrarOrden(){
        System.out.println("el orden id "+idOrden+" de los productos es el siguiente: ");
        for (int i = 0;i < contadorProductos; i++){
            System.out.println("producto n°: " + i + " nombre " + productos[i].getNombre());
        }

       System.out.println("el total es de: " +calcularTotal());
    }

}
