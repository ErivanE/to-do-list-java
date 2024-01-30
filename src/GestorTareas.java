import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class GestorTareas implements Serializable{
//    ArrayList<Tarea> listaTareas = new ArrayList<>();
    ArrayList<Tarea> listaTareas;
    Tarea objTarea;
    Scanner entrada = new Scanner(System.in);
    String nombre = "";
    LocalDate fechaCreacion;
    boolean estado;

    public void AgregarTarea(){
        System.out.println("Tarea: ");
        nombre = entrada.nextLine();
        fechaCreacion = LocalDate.now();
        estado = true;

        //Crea el objeto y lo guarda en el arraylist
        objTarea = new Tarea(nombre,fechaCreacion,estado);
        listaTareas.add(objTarea);

        System.out.println("Tarea agregada con exito");

    }

    public void MarcarTareaCompletada(){
        //Muestra las tareas para despues pedir el numero de tarea a borrar
        MostrarTareas();
        System.out.print("Ingresa el numero de la tarea que terminaste: ");
        int idTarea = entrada.nextInt();
        entrada.nextLine();
        listaTareas.get(idTarea-1).setEstado(false);
        System.out.println("Tarea Completada con exito");
    }
    public void MostrarTareas(){
        //Recorre el arraylist. si el estado de la tarea es activo(true) la muestra sin mas
        //si esta terminada(false) muestra la tarea tachada
        for (int i = 0; i < listaTareas.size(); i++) {
            if(listaTareas.get(i).getEstado()){
                System.out.println((i + 1) + ". Tarea: " + listaTareas.get(i).getNombre() + "   Fecha: " + listaTareas.get(i).getFechaCreacion());
            }else{
                String textoEditado = tacharTexto("Tarea: " + listaTareas.get(i).getNombre() + "   Fecha: " + listaTareas.get(i).getFechaCreacion());
                System.out.println((i + 1) + ". "+textoEditado);
            }
        }
    }
    public void MostrarTareasCompletadas(){
        System.out.println("Tareas TERMINADAS:");
        for(int i = 0; i<listaTareas.size(); i++){
            if(!listaTareas.get(i).getEstado()){
                System.out.println((i+1)+". Tarea: "+listaTareas.get(i).getNombre()+ "  Fecha: "+listaTareas.get(i).getFechaCreacion());
            }
        }
    }
    public void EliminarTareasCompletas(){
        //Comprobar si hay tareas terminadas
        int contadorDeTareasTerminadas = 0;
        for(Tarea tarea : listaTareas){
            if(!tarea.getEstado()){
                contadorDeTareasTerminadas++;
            }
        }
        //si no hay indicar que la lista esta vacia
        if(contadorDeTareasTerminadas == 0){
            System.out.println("No hay tareas finalizadas");
        }else if(contadorDeTareasTerminadas == 1){
            listaTareas.removeIf(tarea -> !tarea.getEstado());
            System.out.println("Tarea eliminada");
        }else{
            listaTareas.removeIf(tarea -> !tarea.getEstado());
            System.out.println("Tareas Eliminadas");
        }
    }
    public void CargarDatos() throws IOException, ClassNotFoundException {
        //al iniciar el programa
        // si hay un arvhico, carga el archivo y guardalo en el array list
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\ieliz\\IdeaProjects\\to-do-list\\save.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        listaTareas = (ArrayList<Tarea>) objectInputStream.readObject();
        objectInputStream.close();

    }
    public void Salir() throws IOException{
        //Al momento de salir guarda todos los datos del array list
        FileOutputStream outputStream = new FileOutputStream("C:\\Users\\ieliz\\IdeaProjects\\to-do-list\\save.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        objectOutputStream.writeObject(listaTareas);
        objectOutputStream.close();
    }
    public String tacharTexto(String texto){
        StringBuilder textTachado = new StringBuilder();
        for(char c : texto.toCharArray()){
            textTachado.append(c).append('\u0336');
        }

        return textTachado.toString();
    }

}
