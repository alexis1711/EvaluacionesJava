package centroescolar;

public class Examen {
    //Atributo
    private String fecha;

    //Constructor
    public Examen(String fecha){
        super();
        this.fecha = fecha;
    }

    //Metodos Get y Set
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "\nFecha: " + this.fecha ;
    }
}
