package ejemplosobreescritura;

public class Gerente extends Empleado{
    private String departamento;

    public Gerente(String nombre, double sueldo, String departamento){
        super(nombre, sueldo);
        this.departamento = departamento;
    }

    //sobreescribimos el metodo padre heredado
    public String obtenerDetalles(){
        //observar como accedemos directamente al atributo heredado
        //debido a que se declaro como protected en la clase padre
        //y por tanto la clase hija o hereda y accede directamente
        return "nombre: " + nombre +", suedo: " + sueldo
                + ", departamento: " + departamento;
    }

    public String getDepartamento(){
        return departamento;
    }

    public void setDepartamento(String departamento){
        this.departamento = departamento;
    }
}
