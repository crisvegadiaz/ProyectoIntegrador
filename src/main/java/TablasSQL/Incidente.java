package TablasSQL;

import java.io.Serializable;
import javax.persistence.Entity;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "incidente")
public class Incidente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "servicio_id", nullable = false)
    private Servicio servicio;

    @ManyToOne
    @JoinColumn(name = "problema_id", nullable = false)
    private Problema problema;

    @Column(name = "estado", nullable = false)
    private String estado;

    @Column(name = "creado_en", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date creadoEn;

    @Column(name = "actualizado_en", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date actualizadoEn;

    @Column(name = "tiempo_resolucion_estimado", nullable = false)
    private int tiempoResolucionEstimado;

    @Column(name = "tiempo_resolucion_real", nullable = false)
    private int tiempoResolucionReal;

    @Column(name = "consideraciones_resolucion", length = 255)
    private String consideracionesResolucion;

    @ManyToOne
    @JoinColumn(name = "operador_id")
    private Operador operador;

    // Constructores
    public Incidente(int id, Cliente cliente, Servicio servicio, Problema problema, String estado, Date creadoEn, Date actualizadoEn, int tiempoResolucionEstimado, int tiempoResolucionReal, String consideracionesResolucion, Operador operador) {
        this.id = id;
        this.cliente = cliente;
        this.servicio = servicio;
        this.problema = problema;
        this.estado = estado;
        this.creadoEn = creadoEn;
        this.actualizadoEn = actualizadoEn;
        this.tiempoResolucionEstimado = tiempoResolucionEstimado;
        this.tiempoResolucionReal = tiempoResolucionReal;
        this.consideracionesResolucion = consideracionesResolucion;
        this.operador = operador;
    }

    public Incidente() {
    }

    // getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getCreadoEn() {
        return creadoEn;
    }

    public void setCreadoEn(Date creadoEn) {
        this.creadoEn = creadoEn;
    }

    public Date getActualizadoEn() {
        return actualizadoEn;
    }

    public void setActualizadoEn(Date actualizadoEn) {
        this.actualizadoEn = actualizadoEn;
    }

    public int getTiempoResolucionEstimado() {
        return tiempoResolucionEstimado;
    }

    public void setTiempoResolucionEstimado(int tiempoResolucionEstimado) {
        this.tiempoResolucionEstimado = tiempoResolucionEstimado;
    }

    public int getTiempoResolucionReal() {
        return tiempoResolucionReal;
    }

    public void setTiempoResolucionReal(int tiempoResolucionReal) {
        this.tiempoResolucionReal = tiempoResolucionReal;
    }

    public String getConsideracionesResolucion() {
        return consideracionesResolucion;
    }

    public void setConsideracionesResolucion(String consideracionesResolucion) {
        this.consideracionesResolucion = consideracionesResolucion;
    }

    public Operador getOperador() {
        return operador;
    }

    public void setOperador(Operador operador) {
        this.operador = operador;
    }

}
