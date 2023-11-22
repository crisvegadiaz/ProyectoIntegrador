package TablasSQL;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tipo")
public class Tipo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "tiempo_maximo_resolucion", nullable = false)
    private int tiempoMaximoResolucion;

    @ManyToOne
    @JoinColumn(name = "especialidad_id", nullable = false)
    private Especialidad especialidad;

    @Column(name = "descripcion", length = 255)
    private String descripcion;

    // Constructores
    public Tipo(int id, String nombre, int tiempoMaximoResolucion, Especialidad especialidad, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.tiempoMaximoResolucion = tiempoMaximoResolucion;
        this.especialidad = especialidad;
        this.descripcion = descripcion;
    }

    public Tipo() {
    }

    // getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTiempoMaximoResolucion() {
        return tiempoMaximoResolucion;
    }

    public void setTiempoMaximoResolucion(int tiempoMaximoResolucion) {
        this.tiempoMaximoResolucion = tiempoMaximoResolucion;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
