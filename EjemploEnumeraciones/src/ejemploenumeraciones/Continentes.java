package ejemploenumeraciones;

public enum Continentes {
    AFRICA(53),
    EUROPA(46),
    ASIA(44),
    AMERICA(34),
    OCEANIA(14);

    //atributo de cada elemento de la enumeracion
    private final int paises;

    //constructor de cada elemento de la enumeracion
    Continentes (int paises){
        this.paises = paises;
    }

    public int getPaises(){
        return paises;
    }
}
