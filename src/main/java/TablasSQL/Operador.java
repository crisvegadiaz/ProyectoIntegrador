package TablasSQL;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "operador")
public class Operador implements Serializable {

    public enum Preferido {
        Email, WhatsApp
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "correo_electronico", nullable = false)
    private String correoElectronico;

    @Column(name = "whatsApp", nullable = false)
    private String whatsApp;

    @Column(name = "metodo_preferido_notificacion", nullable = false, columnDefinition = "ENUM('Email', 'WhatsApp')")
    @Enumerated(EnumType.STRING)
    private Preferido metodoPreferidoNotificacion;

    // Constructores
    public Operador(int id, String nombre, String correoElectronico, String whatsApp, Preferido metodoPreferidoNotificacion) {
        this.id = id;
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.whatsApp = whatsApp;
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

    public String getWhatsApp() {
        return whatsApp;
    }

    public void setWhatsApp(String whatsApp) {
        this.whatsApp = whatsApp;
    }

    public Preferido getMetodoPreferidoNotificacion() {
        return metodoPreferidoNotificacion;
    }

    public void setMetodoPreferidoNotificacion(Preferido metodoPreferidoNotificacion) {
        this.metodoPreferidoNotificacion = metodoPreferidoNotificacion;
    }

    @Override
    public String toString() {
        return "Operador{" + "id=" + id + ", nombre=" + nombre + ", correoElectronico=" + correoElectronico + ", whatsApp=" + whatsApp + ", metodoPreferidoNotificacion=" + metodoPreferidoNotificacion + '}';
    }

}
