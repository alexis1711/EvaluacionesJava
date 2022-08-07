package centroescolar;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Alumno implements alumnoMetodos{

    //Atributos de alumno
    private final int idAlumno;
    private static int contadorAlumnos = 1;
    private String nombre;
    private String apellido;
    private String dui;
    List<Escrito> escritos = new ArrayList();
    List<Oral> orales = new ArrayList<>();

    //Constructores
    public Alumno(){
        this.idAlumno = contadorAlumnos++;
    }

    public Alumno(String nombre, String apellido, String dui){
        this();
        this.nombre = nombre;
        this.apellido = apellido;
        this.dui = dui;
    }

    //Metodos Get y Set

    public int getIdAlumno() {
        return idAlumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public List<Escrito> getEscritos() {
        return escritos;
    }

    public List<Oral> getOrales() {
        return orales;
    }

    //Metodo para agregar examen a una lista
    public void agregarExamen(Examen examen){
        //Uso de instanceof para verificar de que tipo es el objeto que se envió

        if(examen instanceof Escrito){ //Si es escrito se agrega a lista de examenes escritos
            Escrito escrito = (Escrito) examen;
            this.escritos.add(escrito);
        }
        else { //Si no se agrega a lista de examenes orales
            Oral oral = (Oral) examen;
            this.orales.add(oral);
        }
    }

    //Metodo para mostrar los examenes guardados
    public void mostrarExamenes(){
        
        //Examenes escritos
        System.out.println("");
        System.out.println("Examenes escritos");
        Iterator<Escrito> recorrerEscrito = escritos.iterator(); //Uso de iteradores para recorrer la lista
        if(recorrerEscrito.hasNext()){
            while(recorrerEscrito.hasNext()){
                Escrito elemento = recorrerEscrito.next();
                System.out.println(elemento);
            }
        }
        else
            System.out.println("No hay examenes escritos registrados... ");

        //Examenes orales
        System.out.println("");
        System.out.println("Examenes Orales");
        Iterator<Oral> recorrerOral = orales.iterator(); //Uso de iteradores para recorrer la lista
        if(recorrerOral.hasNext()){
            while(recorrerOral.hasNext()){
                Oral elemento = recorrerOral.next();
                System.out.println(elemento);
            }
        }
        else
            System.out.println("No hay examenes orales registrados... ");
    }

    @Override
    public String toString() {
        return "\nAlumno no." + this.idAlumno + "\nNombre: " + nombre + "\nApellido: " + apellido + "\nDui: " + dui;
    }

}
