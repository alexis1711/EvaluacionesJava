package centroescolar;

public class Escrito extends Examen{
    //Atributos
    private final int idEscrito;
    private static int contadorEscritos = 1;
    private int duracion;
    private double nota;

    //Constructor
    public Escrito(int duracion, double nota, String fecha){
        //Envio de fecha a superclase
        super(fecha);
        this.idEscrito = contadorEscritos++;
        this.duracion = duracion;
        this.nota = nota;
    }

    //Metodos Get y Set
    public int getIdEscrito() {
        return idEscrito;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "\nExamen escrito no. " + this.idEscrito + super.toString() + "\nDuracion: " + this.duracion + " minutos" + "\nNota: " + this.nota;
    }
}
