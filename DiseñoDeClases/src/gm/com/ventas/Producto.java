package gm.com.ventas;

public class Producto {
    private int idProducto;
    private String nombre;
    private double precio;
    private static int contadorProducto;

    private Producto(){
        this.idProducto = ++contadorProducto;
    }

    public Producto(String nombre, double precio){
        this();
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        //return super.toString();
        return "Producto: {idProducto: " + this.idProducto + "nombre: " + this.nombre + "precio: " + this.precio;
    }
}
