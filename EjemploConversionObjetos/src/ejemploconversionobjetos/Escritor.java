package ejemploconversionobjetos;

public class Escritor extends Empleado{

    final TipoEscritura tipoEscritura;

    public Escritor(String nombre, double sueldo, TipoEscritura tipoEscritura){
        super(nombre, sueldo);
        this.tipoEscritura = tipoEscritura;
    }

    //sobreescribimos el obtener detalles de la clase padre
    @Override
    public String obtenerDetalle() {
        return super.obtenerDetalle() + ", tipo de escritura: " + tipoEscritura;
    }

    public TipoEscritura getTipoEscritura() {
        return tipoEscritura;
    }

    public String getTipoEscrituraEnTexto() {
        return tipoEscritura.getDescripcion();
    }
}
