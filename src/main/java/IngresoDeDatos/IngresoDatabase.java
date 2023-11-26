package IngresoDeDatos;

import TablasSQL.Cliente;
import TablasSQL.Especialidad;
import TablasSQL.Incidente;
import TablasSQL.Operador;
import TablasSQL.Problema;
import TablasSQL.Servicio;
import TablasSQL.ServicioProblemaRelacion;
import TablasSQL.Tipo;

import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class IngresoDatabase {

    private final String conexionDatabase;

    public IngresoDatabase(String nombreConexion) {
        this.conexionDatabase = nombreConexion;
    }

    public void ingresoDatoCliente(String nombre, String cuit, String direccion, String email, String telefono) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory(this.conexionDatabase);
        EntityManager em = emf.createEntityManager();

        // Crear una nueva transacción
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        try {
            // Crear una instancia de Cliente
            Cliente nuevoCliente = new Cliente();
            nuevoCliente.setNombre(nombre);
            nuevoCliente.setCuit(cuit);
            nuevoCliente.setDireccion(direccion);
            nuevoCliente.setCorreoElectronico(email);
            nuevoCliente.setTelefono(telefono);
            nuevoCliente.setFechaInicioContrato(new Date());

            // Persistir el nuevo cliente
            em.persist(nuevoCliente);

            // Commit de la transacción
            transaction.commit();

            System.out.println("Cliente guardado con éxito.");
        } catch (Exception e) {
            // Manejar excepciones
            if (transaction.isActive()) {
                transaction.rollback();
            }
        } finally {
            // Cerrar el EntityManager
            em.close();
            emf.close();
        }
    }

    public void ingresoDatoEspecialidad(String especialidad, String descripcion) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory(this.conexionDatabase);
        EntityManager em = emf.createEntityManager();

        // Crear una nueva transacción
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        try {
            // Crear una instancia de Especialidad
            Especialidad nuevaEspecialidad = new Especialidad();
            nuevaEspecialidad.setNombre(especialidad);
            nuevaEspecialidad.setDescripcion(descripcion);

            // Persistir la nueva especialidad
            em.persist(nuevaEspecialidad);

            // Commit de la transacción
            transaction.commit();

            System.out.println("Especialidad guardada con éxito.");
        } catch (Exception e) {
            // Manejar excepciones
            if (transaction.isActive()) {
                transaction.rollback();
            }
        } finally {
            // Cerrar el EntityManager
            em.close();
            emf.close();
        }
    }

    public void ingresoDatoOperador(String nombre, String email, String whatsApp, String metodoPreferido) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(this.conexionDatabase);
        EntityManager em = emf.createEntityManager();

        // Crear una nueva transacción
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        if (!metodoPreferido.equals("Email") && !metodoPreferido.equals("WhatsApp")) {
            System.err.println("El Metodo Preferido Notificacion solo permite ( Email, WhatsApp )");
            return;
        }

        try {
            // Crear una instancia de Operador
            Operador nuevaOperador = new Operador();
            nuevaOperador.setNombre(nombre);
            nuevaOperador.setCorreoElectronico(email);
            nuevaOperador.setWhatsApp(whatsApp);
            nuevaOperador.setMetodoPreferidoNotificacion(Operador.Preferido.valueOf(metodoPreferido));

            // Persistir la nueva Operador
            em.persist(nuevaOperador);

            // Commit de la transacción
            transaction.commit();

            System.out.println("Operador guardada con éxito.");
        } catch (Exception e) {
            // Manejar excepciones
            if (transaction.isActive()) {
                transaction.rollback();
            }
        } finally {
            // Cerrar el EntityManager
            em.close();
            emf.close();
        }

    }

    public void ingresoDatoProblema(Integer gravedad, String descripcion) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(this.conexionDatabase);
        EntityManager em = emf.createEntityManager();

        // Crear una nueva transacción
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        try {
            // Crear una instancia de Problema
            Problema nuevoProblema = new Problema();
            nuevoProblema.setGravedad(gravedad);
            nuevoProblema.setDescripcion(descripcion);

            // Persistir la nueva Problema
            em.persist(nuevoProblema);

            // Commit de la transacción
            transaction.commit();

            System.out.println("Problema guardada con éxito.");
        } catch (Exception e) {
            // Manejar excepciones
            if (transaction.isActive()) {
                transaction.rollback();
            }
        } finally {
            // Cerrar el EntityManager
            em.close();
            emf.close();
        }
    }

    public void ingresoDatoServicio(String nombre, Integer idEspecialidad) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(this.conexionDatabase);
        EntityManager em = emf.createEntityManager();

        // Crear una nueva transacción
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        try {

            int idEspecialidadExistente = idEspecialidad;
            Especialidad especialidadExistente = em.find(Especialidad.class, idEspecialidadExistente);

            if (especialidadExistente != null) {
                // Crear una instancia de Servicio
                Servicio nuevoServicio = new Servicio();
                nuevoServicio.setNombre(nombre);
                nuevoServicio.setEspecialidad(especialidadExistente);

                // Persistir la nueva Servicio
                em.persist(nuevoServicio);

                // Commit de la transacción
                transaction.commit();

                System.out.println("Especialidad guardada con éxito.");
            } else {
                System.err.println("Especialidad no encontrada con el ID proporcionado.");
            }

        } catch (Exception e) {
            // Manejar excepciones
            if (transaction.isActive()) {
                transaction.rollback();
            }
        } finally {
            // Cerrar el EntityManager
            em.close();
            emf.close();
        }
    }

    public void ingresoDatoTipo(Integer idEspecialidad, String nombre, Integer tiempoMaximoResolucion, String descripcion, Integer tiempoResolucionEstimado) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(this.conexionDatabase);
        EntityManager em = emf.createEntityManager();

        // Crear una nueva transacción
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        try {

            // Buscar un Especialidad existente por su ID 
            int idEspecialidadExistente = idEspecialidad;
            Especialidad especialidadExistente = em.find(Especialidad.class, idEspecialidadExistente);

            if (especialidadExistente != null) {
                // Crear una instancia de Tipo
                Tipo nuevotipo = new Tipo();
                nuevotipo.setNombre(nombre);
                nuevotipo.setTiempoMaximoResolucion(tiempoMaximoResolucion);
                nuevotipo.setEspecialidad(especialidadExistente);
                nuevotipo.setDescripcion(descripcion);
                nuevotipo.setTiempoResolucionEstimado(tiempoResolucionEstimado);

                // Persiste el Tipo
                em.persist(nuevotipo);

                // Realiza el commit de la transacción
                transaction.commit();

                System.out.println("Tipo guardado con éxito.");
            } else {
                System.err.println("Especialidad no encontrada con el ID proporcionado.");
            }
        } catch (Exception e) {
            // Manejo de excepciones
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            // Cierra el EntityManager y EntityManagerFactory
            em.close();
            emf.close();
        }
    }

    public void ingresoDatoIncidente(Integer idCliente, Integer idServicio, Integer idProblema, Integer idTipo, Integer idOperador, String estado, Date creadoEn, Date actualizadoEn, Integer tiempoResolucionEstimado, Integer tiempoResolucionReal, String consideraciones) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(this.conexionDatabase);
        EntityManager em = emf.createEntityManager();

        // Crear una nueva transacción
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        try {

            // Buscar un Cliente existente por su ID 
            int idClienteExistente = idCliente;
            Cliente clienteExistente = em.find(Cliente.class, idClienteExistente);

            // Buscar un Servicio existente por su ID 
            int idServicioExistente = idServicio;
            Servicio servicioExistente = em.find(Servicio.class, idServicioExistente);

            // Buscar un Problema existente por su ID 
            int idProblemaExistente = idProblema;
            Problema problemaExistente = em.find(Problema.class, idProblemaExistente);

            // Buscar un Operador existente por su ID 
            int idOperadorExistente = idOperador;
            Operador operadorExistente = em.find(Operador.class, idOperadorExistente);

            // Buscar un Tipo existente por su ID 
            int idTipoExistente = idTipo;
            Tipo tipoExistente = em.find(Tipo.class, idTipoExistente);

            if (!estado.equals("Abierto") && !estado.equals("EnProceso") && !estado.equals("Cerrado")) {
                System.err.println("El estado solo permite (Abierto, EnProceso, Cerrado)");
                return;
            }

            // Verificar si los elementos existen antes de proceder
            if (clienteExistente != null && servicioExistente != null && problemaExistente != null && operadorExistente != null && tipoExistente != null) {
                // Crea una instancia de Incidente
                Incidente nuevoIncidente = new Incidente();
                nuevoIncidente.setCliente(clienteExistente);
                nuevoIncidente.setServicio(servicioExistente);
                nuevoIncidente.setProblema(problemaExistente);
                nuevoIncidente.setEstado(Incidente.Estado.valueOf(estado));
                nuevoIncidente.setCreadoEn(creadoEn);
                nuevoIncidente.setActualizadoEn(actualizadoEn);
                nuevoIncidente.setTiempoResolucionEstimado(tiempoResolucionEstimado);
                nuevoIncidente.setTiempoResolucionReal(tiempoResolucionReal);
                nuevoIncidente.setConsideracionesResolucion(consideraciones);
                nuevoIncidente.setOperador(operadorExistente);
                nuevoIncidente.setTipo(tipoExistente);

                // Persiste el Incidente
                em.persist(nuevoIncidente);

                // Realiza el commit de la transacción
                transaction.commit();

                System.out.println("Incidente guardado con éxito.");
            } else {
                System.err.println("Cliente, Servicio, Tipo, Problema o Operador no encontrados con los IDs proporcionados.");
            }
        } catch (Exception e) {
            // Manejo de excepciones
            if (transaction.isActive()) {
                transaction.rollback();
            }
        } finally {
            // Cierra el EntityManager y EntityManagerFactory
            em.close();
            emf.close();
        }
    }

    public void ingresoDatoServicioProblemaRelacion(Integer idProblema, Integer idServicio) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(this.conexionDatabase);
        EntityManager em = emf.createEntityManager();

        // Crear una nueva transacción
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        try {

            // Buscar un Problema existente por su ID 
            int idProblemaExistente = idProblema;
            Problema problemaExistente = em.find(Problema.class, idProblemaExistente);

            // Buscar un Servicio  existente por su ID 
            int idServicioExistente = idServicio;
            Servicio servicioExistente = em.find(Servicio.class, idServicioExistente);

            if (problemaExistente != null && servicioExistente != null) {
                // Crear una instancia de ServicioProblemaRelacion
                ServicioProblemaRelacion servicioProblemaRelacion = new ServicioProblemaRelacion();
                servicioProblemaRelacion.setProblema(problemaExistente);
                servicioProblemaRelacion.setServicio(servicioExistente);

                // Persiste el ServicioProblemaRelacion
                em.persist(servicioProblemaRelacion);

                // Realiza el commit de la transacción
                transaction.commit();

                System.out.println("Servicio Problema Relacion guardado con éxito.");
            } else {
                System.err.println("Problema, Servicio no encontrada con el ID proporcionado.");
            }
        } catch (Exception e) {
            // Manejo de excepciones
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            // Cierra el EntityManager y EntityManagerFactory
            em.close();
            emf.close();
        }
    }
}
