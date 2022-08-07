package menu;

import centroescolar.Alumno;
import centroescolar.Escrito;
import centroescolar.NivelSatisfaccion;
import centroescolar.Oral;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class menu {

    //Lista de alumnos en general
    private static List<Alumno> listaAlumnos = new ArrayList<>();


    public static void main(String[] args) {
        int opcion;
        //Opciones a realizar
        do{
            System.out.println("");
            System.out.println("MENU DE OPCIONES");
            System.out.println("1- Registrar Alumno");
            System.out.println("2- Verificar Alumnos Aprobados");
            System.out.println("3- Verificar Alumnos");
            System.out.println("4- Salir");
            System.out.print("Digite la opcion a realizar: ");
            Scanner scan = new Scanner(System.in);
            opcion = scan.nextInt();
            switch(opcion) {
                case 1:
                    //Registro de alumno nuevo
                    Alumno alumno = new Alumno();
                    int examen = 1;
                    System.out.print("Ingrese el nombre: ");
                    alumno.setNombre(scan.next());
                    System.out.print("Ingrese el apellido: ");
                    alumno.setApellido(scan.next());
                    System.out.print("Ingrese el DUI: ");
                    alumno.setDui(scan.next());
                    do {
                        int tipo;
                        //Opciones del tipo de examen a ingresar
                        System.out.print("Ingrese el tipo de examen según lo indicado (1- Escrito 2- Oral): ");
                        tipo = scan.nextInt();
                        int dia, mes, año;
                        String fecha;
                        switch (tipo) {
                            case 1:
                                //Ingresar examen escrito
                                int duracion;
                                double nota;
                                System.out.println("Ingrese la fecha de realizacion(en numeros) segun lo indicado");
                                System.out.print("Dia: ");
                                dia = scan.nextInt();
                                System.out.print("Mes: ");
                                mes = scan.nextInt();
                                System.out.print("Anio: ");
                                año = scan.nextInt();
                                System.out.print("Ingrese la duracion del examen (en minutos): ");
                                duracion = scan.nextInt();
                                System.out.print("Ingrese la nota obtenida: ");
                                nota = scan.nextDouble();
                                fecha = dia + "/" + mes + "/" + año;
                                Escrito escrito = new Escrito(duracion, nota, fecha);
                                alumno.agregarExamen(escrito);
                                break;
                            case 2:
                                //Ingresar examen oral
                                int nivelSatisfaccionId;
                                NivelSatisfaccion nivelSatisfaccion = NivelSatisfaccion.INSUFICIENTE;
                                System.out.println("Ingrese la fecha de realizacion(en numeros) según lo indicado");
                                System.out.print("Dia: ");
                                dia = scan.nextInt();
                                System.out.print("Mes: ");
                                mes = scan.nextInt();
                                System.out.print("Anio: ");
                                año = scan.nextInt();
                                System.out.println("Indique el numero de nivel de satisfaccion obtenido");
                                System.out.println("1- Insuficiente  2- Suficiente  3- Excelente");
                                nivelSatisfaccionId = scan.nextInt();
                                fecha = dia + "/" + mes + "/" + año;
                                //Verificacion del nivel de satisfaccion a ingresar mediante el enum
                                if (nivelSatisfaccionId == 3)
                                    nivelSatisfaccion = NivelSatisfaccion.EXCELENTE;
                                else if (nivelSatisfaccionId == 2)
                                    nivelSatisfaccion = NivelSatisfaccion.SUFICIENTE;
                                Oral oral = new Oral(nivelSatisfaccion, fecha);
                                alumno.agregarExamen(oral);
                                break;
                            default:
                                System.out.println("Opcion no valida... ");
                                break;
                        }
                        System.out.println("¿Desea registrar otro examen? 1- Si   2- No");
                        examen = scan.nextInt();
                    } while (examen != 2);
                    //Ingreso del alumno con todos sus datos y examenes a la lista
                    listaAlumnos.add(alumno);
                    break;
                case 2:
                    //Mostrar alumnos aprobados, mediante el metodo aprobados
                    System.out.println("\nAlumnos aprobados");
                    aprobados();
                    break;
                case 3:
                    //Mostrar todos los alumnos de la clase, mediante el metodo lista general
                    System.out.println("\nListado de Alumnos");
                    listaGeneral();
                    break;
                case 4:
                    //Opcion de salida del sistema
                    System.out.println("Gracias por utilizar el sistema... ");
                    break;
                default:
                    //Opcion invalida del menú
                    System.out.println("Ingrese una opción valida... ");
                    break;
            }
        }while(opcion != 4);
    }

    //Metodo que verifica los alumnos aprobados y sus datos, mediante el metodo verificarAprobacion
    //y los muestra mediante el metodo imprimirAlumnos
    private static void aprobados() {
        for (Alumno alumno: listaAlumnos) {
            if(verificarAprobacion(alumno)){
                imprimirAlumnos(alumno);
            }
        }
    }

    //Metodo que muestra toda la lista de alumnos y sus datos, mediante el metodo imprimirAlumnos
    private static void listaGeneral(){
        for(Alumno alumno: listaAlumnos){
            imprimirAlumnos(alumno);
        }
    }

    //Metodo que imprime los datos de cada alumno el cual se le envie como parametro
    private static void imprimirAlumnos(Alumno alumno){
        System.out.println(alumno.toString());
        alumno.mostrarExamenes();
    }

    //Metodo que verifica los examenes de un alumno para ver si aprueba o no
    private static boolean verificarAprobacion(Alumno alumno){
        boolean aprobacion = true;

        //Verificacion examenes escritos
        for(Escrito examenEsc : alumno.getEscritos()){
            if((examenEsc.getDuracion()<90)&&(examenEsc.getNota()>=6)){

            }
            else{
                aprobacion = false;
            }
        }

        //Verificacion examanes orales
        for (Oral examenOr : alumno.getOrales()){
            if(examenOr.getNivelSatisfaccion() == NivelSatisfaccion.INSUFICIENTE){
                aprobacion = false;
            }
            else{

            }
        }
        return aprobacion;
    }
}
