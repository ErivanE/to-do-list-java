import java.io.Serializable;
import java.time.LocalDate;

public class Tarea implements Serializable {
    private String nombre;
    private LocalDate fechaCreacion;
    private boolean estado;

    public Tarea(String nombre, LocalDate fechaCreacion, boolean estado){
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaCreacion(){
        return fechaCreacion;
    }

    public boolean getEstado(){
        return estado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaCreacion(LocalDate fechaCreacion){
        this.fechaCreacion = fechaCreacion;
    }

    public void setEstado(boolean estado){
        this.estado = estado;
    }
}
