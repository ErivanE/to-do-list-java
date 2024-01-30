import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        GestorTareas tareas = new GestorTareas();
        tareas.CargarDatos();
        Scanner entrada = new Scanner(System.in);
        int opcion;

        do{
            System.out.println("To-Do List");
            System.out.println("Selecciona una opcion");
            System.out.println("1. Agregar Tarea");
            System.out.println("2. Marcar Tarea completada");
            System.out.println("3. Ver lista de tareas");
            System.out.println("4. Ver tareas completadas");
            System.out.println("5. Eliminar tareas completadas");
            System.out.println("6. Salir");
            opcion = entrada.nextInt();

            entrada.nextLine(); //!!!

            switch (opcion){
                case 1:
                    tareas.AgregarTarea();
                    System.out.println("\n");
                    break;
                case 2:
                    tareas.MarcarTareaCompletada();
                    System.out.println("\n");
                    break;
                case 3:
                    tareas.MostrarTareas();
                    System.out.println("\n");
                    break;
                case 4:
                    tareas.MostrarTareasCompletadas();
                    System.out.println("\n");
                    break;
                case 5:
                    tareas.EliminarTareasCompletas();
                    System.out.println("\n");
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    tareas.Salir();
                    break;
                default:
                    System.out.println("Selecciona una opcion valida");
            }
        }while(opcion != 6);
    }

}
