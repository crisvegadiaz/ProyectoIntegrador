package TablasSQL;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "operador")
public class Operador implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "correo_electronico", nullable = false)
    private String correoElectronico;

    @Column(name = "metodo_preferido_notificacion")
    private String metodoPreferidoNotificacion;

    // Constructores
    public Operador(int id, String nombre, String correoElectronico, String metodoPreferidoNotificacion) {
        this.id = id;
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.metodoPreferidoNotificacion = metodoPreferidoNotificacion;
    }

    public Operador() {
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

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getMetodoPreferidoNotificacion() {
        return metodoPreferidoNotificacion;
    }

    public void setMetodoPreferidoNotificacion(String metodoPreferidoNotificacion) {
        this.metodoPreferidoNotificacion = metodoPreferidoNotificacion;
    }

}
