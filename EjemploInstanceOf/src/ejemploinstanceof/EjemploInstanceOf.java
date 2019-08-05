package ejemploinstanceof;

public class EjemploInstanceOf {

    public static void main(String[] args){

        FiguraGeometrica figura;

        figura = new Elipse();
        //determina di es instancia del objeto
        determinaTipo( figura );
        //determina la instancia de todos os tipos
        System.out.println( "todas las instancias" );
        determinaTodosLosTipos(figura);

    }

    private static void determinaTodosLosTipos( FiguraGeometrica figura ){

        if( figura instanceof Elipse)
        {
            System.out.println( "figura es instancia de elipse" );
        }
        if ( figura instanceof Circulo)
        {
            System.out.println( "figura es instancia de Circulo" );
        }
        if ( figura instanceof Rectangulo)
        {
            System.out.println( "figura es instancia de Rectangulo" );
        }
        if ( figura instanceof Triangulo)
        {
            System.out.println( "figura es instancia de Triangulo" );
        }
        if ( figura instanceof FiguraGeometrica)
        {
            System.out.println( "figura es instancia de FiguraGeometrica" );
        }
        if ( figura instanceof Object)
        {
            System.out.println( "figura es instancia de Object" );
        } else
        {
            System.out.println( "figura no es instancia" );
        }
    }

    private static void determinaTipo( FiguraGeometrica figura ){

        if( figura instanceof Elipse)
        {
            System.out.println( "figura es instancia de elipse" );
        } else if ( figura instanceof Circulo)
        {
            System.out.println( "figura es instancia de Circulo" );
        } else if ( figura instanceof Rectangulo)
        {
            System.out.println( "figura es instancia de Rectangulo" );
        } else if ( figura instanceof Triangulo)
        {
            System.out.println( "figura es instancia de Triangulo" );
        } else if ( figura instanceof FiguraGeometrica)
        {
            System.out.println( "figura es instancia de FiguraGeometrica" );
        } else if ( figura instanceof Object)
        {
            System.out.println( "figura es instancia de Object" );
        }else {
            System.out.println( "figura no es instancia" );
        }
    }

}
