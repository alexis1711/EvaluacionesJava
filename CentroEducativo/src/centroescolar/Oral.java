package centroescolar;

public class Oral extends Examen{
    //Atributos
    private final int idOral;
    private static int contadorOrales = 1;
    private NivelSatisfaccion nivelSatisfaccion;

    //Constructor
    public Oral(NivelSatisfaccion nivelSatisfaccion, String fecha){
        super(fecha);
        this.idOral = contadorOrales++;
        this.nivelSatisfaccion = nivelSatisfaccion;
    }

    //Metodos Get y Set
    public int getIdOral() {
        return idOral;
    }

    public NivelSatisfaccion getNivelSatisfaccion() {
        return nivelSatisfaccion;
    }

    public void setNivelSatisfaccion(NivelSatisfaccion nivelSatisfaccion) {
        this.nivelSatisfaccion = nivelSatisfaccion;
    }

    @Override
    public String toString() {
        return "\nExamen oral no. " + this.idOral + super.toString() + "\nNivel de satisfaccion obtenido: " + this.nivelSatisfaccion;
    }
}
