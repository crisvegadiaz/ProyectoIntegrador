package TablasSQL;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "servicio_problema_relacion")
public class ServicioProblemaRelacion implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "servicio_id", nullable = false)
    private Servicio servicio;

    @Id
    @ManyToOne
    @JoinColumn(name = "problema_id", nullable = false)
    private Problema problema;

    // Constructores
    public ServicioProblemaRelacion(Servicio servicio, Problema problema) {
        this.servicio = servicio;
        this.problema = problema;
    }

    public ServicioProblemaRelacion() {
    }
    // getters and setters

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Problema getProblema() {
        return problema;
    }

    public void setProblema(Problema problema) {
        this.problema = problema;
    }

    @Override
    public String toString() {
        return "ServicioProblemaRelacion{" + "servicio=" + servicio + ", problema=" + problema + '}';
    }
}
