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
import javax.persistence.Query;

public class IngresoDatabase {

    private final String conexionDatabase;

    public IngresoDatabase(String nombreConexion) {
        this.conexionDatabase = nombreConexion;
    }

    // Create de Datos
    public void createCliente(String nombre, String cuit, String direccion, String email, String telefono) {

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

    public void createEspecialidad(String especialidad, String descripcion) {

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

    public void createOperador(String nombre, String email, String whatsApp, String metodoPreferido) {
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

    public void createProblema(Integer gravedad, String descripcion) {
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

    public void createServicio(String nombre, Integer idEspecialidad) {
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

    public void createTipo(Integer idEspecialidad, String nombre, Integer tiempoMaximoResolucion, String descripcion, Integer tiempoResolucionEstimado) {
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
        } finally {
            // Cierra el EntityManager y EntityManagerFactory
            em.close();
            emf.close();
        }
    }

    public void createIncidente(Integer idCliente, Integer idServicio, Integer idProblema, Integer idTipo, Integer idOperador, String estado, Date creadoEn, Date actualizadoEn, Integer tiempoResolucionEstimado, Integer tiempoResolucionReal, String consideraciones) {
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

    public void createServicioProblemaRelacion(Integer idProblema, Integer idServicio) {
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
        } finally {
            // Cierra el EntityManager y EntityManagerFactory
            em.close();
            emf.close();
        }
    }

    // Update Datos
    public void updateCliente(Integer idCliente, String nombre, String cuit, String direccion, String email, String telefono) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory(this.conexionDatabase);
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Cliente clienteToUpdate = em.find(Cliente.class, idCliente);
        if (clienteToUpdate != null) {
            clienteToUpdate.setNombre(nombre);
            clienteToUpdate.setCuit(cuit);
            clienteToUpdate.setDireccion(direccion);
            clienteToUpdate.setCorreoElectronico(email);
            clienteToUpdate.setTelefono(telefono);
            clienteToUpdate.setFechaInicioContrato(new Date());
        } else {
            System.err.println("Cliente no encontrado con el ID proporcionado.");
        }

        em.getTransaction().commit();

        em.close();
        emf.close();
    }

    public void updateCliente(int idCliente, String campo, String nuevoValor) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(this.conexionDatabase);
        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();

            String jpql = "UPDATE Cliente c SET c." + campo + " = :nuevoValor WHERE c.id = :idCliente";

            Query query = em.createQuery(jpql);
            query.setParameter("nuevoValor", nuevoValor);
            query.setParameter("idCliente", idCliente);

            int filasActualizadas = query.executeUpdate();

            transaction.commit();

            System.out.println("Se actualizaron " + filasActualizadas + " filas.");
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.err.println("Error al actualizar el cliente.");
        } finally {
            em.close();
            emf.close();
        }
    }

    public void updateEspecialidad(Integer idEspecialidad, String especialidad, String descripcion) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(this.conexionDatabase);
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Especialidad especialidadToUpdate = em.find(Especialidad.class, idEspecialidad);

        if (especialidadToUpdate != null) {
            especialidadToUpdate.setNombre(especialidad);
            especialidadToUpdate.setDescripcion(descripcion);
        } else {
            System.err.println("Especialidad no encontrado con el ID proporcionado.");
        }

        em.getTransaction().commit();

        em.close();
        emf.close();
    }

    public void updateEspecialidad(int idEspecialidad, String campo, String nuevoValor) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(this.conexionDatabase);
        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();

            String jpql = "UPDATE Especialidad e SET e." + campo + " = :nuevoValor WHERE e.id = :idEspecialidad";

            Query query = em.createQuery(jpql);
            query.setParameter("nuevoValor", nuevoValor);
            query.setParameter("idEspecialidad", idEspecialidad);

            int filasActualizadas = query.executeUpdate();

            transaction.commit();

            System.out.println("Se actualizaron " + filasActualizadas + " filas.");
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.err.println("Error al actualizar la especialidad.");
        } finally {
            em.close();
            emf.close();
        }
    }

    public void updateOperador(Integer idOperador, String nombre, String email, String whatsApp, String metodoPreferido) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(this.conexionDatabase);
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Operador operadorToUpdate = em.find(Operador.class, idOperador);

        if (operadorToUpdate != null) {
            operadorToUpdate.setNombre(nombre);
            operadorToUpdate.setCorreoElectronico(email);
            operadorToUpdate.setWhatsApp(whatsApp);
            operadorToUpdate.setMetodoPreferidoNotificacion(Operador.Preferido.valueOf(metodoPreferido));
        } else {
            System.err.println("Operador no encontrado con el ID proporcionado.");
        }

        em.getTransaction().commit();

        em.close();
        emf.close();
    }

    public void updateOperador(int idOperador, String campo, String nuevoValor) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(this.conexionDatabase);
        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();

            String jpql = "UPDATE Operador o SET o." + campo + " = :nuevoValor WHERE o.id = :idOperador";

            Query query = em.createQuery(jpql);
            query.setParameter("nuevoValor", nuevoValor);
            query.setParameter("idOperador", idOperador);

            int filasActualizadas = query.executeUpdate();

            transaction.commit();

            System.out.println("Se actualizaron " + filasActualizadas + " filas.");
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.err.println("Error al actualizar el operador.");
        } finally {
            em.close();
            emf.close();
        }
    }

    public void updateProblema(Integer idProblema, Integer gravedad, String descripcion) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(this.conexionDatabase);
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Problema problemaToUpdate = em.find(Problema.class, idProblema);

        if (problemaToUpdate != null) {
            problemaToUpdate.setGravedad(gravedad);
            problemaToUpdate.setDescripcion(descripcion);
        } else {
            System.err.println("Problema no encontrado con el ID proporcionado.");
        }

        em.getTransaction().commit();

        em.close();
        emf.close();
    }

    public void updateProblema(int idProblema, String campo, String nuevoValor) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(this.conexionDatabase);
        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();

            String jpql = "UPDATE Problema p SET p." + campo + " = :nuevoValor WHERE p.id = :idProblema";

            Query query = em.createQuery(jpql);
            query.setParameter("nuevoValor", nuevoValor);
            query.setParameter("idProblema", idProblema);

            int filasActualizadas = query.executeUpdate();

            transaction.commit();

            System.out.println("Se actualizaron " + filasActualizadas + " filas.");
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.err.println("Error al actualizar el problema.");
        } finally {
            em.close();
            emf.close();
        }
    }

    public void updateServicio(Integer idServicio, String nombre, Integer idEspecialidad) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(this.conexionDatabase);
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Servicio servicioToUpdate = em.find(Servicio.class, idServicio);

        int idEspecialidadExistente = idEspecialidad;
        Especialidad especialidadExistente = em.find(Especialidad.class, idEspecialidadExistente);

        if (especialidadExistente != null) {
            servicioToUpdate.setNombre(nombre);
            servicioToUpdate.setEspecialidad(especialidadExistente);
        } else {
            System.err.println("Especialidad no encontrada con el ID proporcionado.");
        }

        em.getTransaction().commit();

        em.close();
        emf.close();
    }

    public void updateServicio(int idServicio, String campo, String nuevoValor) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(this.conexionDatabase);
        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();

            if (campo.equals("idEspecialidad")) {
                campo = "especialidad.id";
            }

            String jpql = "UPDATE Servicio s SET s." + campo + " = :nuevoValor WHERE s.id = :idServicio";

            Query query = em.createQuery(jpql);
            query.setParameter("nuevoValor", nuevoValor);
            query.setParameter("idServicio", idServicio);

            int filasActualizadas = query.executeUpdate();

            transaction.commit();

            System.out.println("Se actualizaron " + filasActualizadas + " filas.");
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.err.println("Error al actualizar el servicio.");
        } finally {
            em.close();
            emf.close();
        }
    }

    public void updateTipo(Integer idTipo, String nombre, Integer tiempoMaximoResolucion, String descripcion, Integer tiempoResolucionEstimado) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(this.conexionDatabase);
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Tipo tipoToUpdate = em.find(Tipo.class, idTipo);

        if (tipoToUpdate != null) {
            tipoToUpdate.setNombre(nombre);
            tipoToUpdate.setTiempoMaximoResolucion(tiempoMaximoResolucion);
            tipoToUpdate.setDescripcion(descripcion);
            tipoToUpdate.setTiempoResolucionEstimado(tiempoResolucionEstimado);
        } else {
            System.err.println("Tipo no encontrado con el ID proporcionado.");
        }

        em.getTransaction().commit();

        em.close();
        emf.close();
    }

    public void updateTipo(int idTipo, String campo, String nuevoValor) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(this.conexionDatabase);
        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();

            String jpql = "UPDATE Tipo t SET t." + campo + " = :nuevoValor WHERE t.id = :idTipo";

            Query query = em.createQuery(jpql);
            query.setParameter("nuevoValor", nuevoValor);
            query.setParameter("idTipo", idTipo);

            int filasActualizadas = query.executeUpdate();

            transaction.commit();

            System.out.println("Se actualizaron " + filasActualizadas + " filas.");
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.err.println("Error al actualizar el tipo.");
        } finally {
            em.close();
            emf.close();
        }
    }

    public void updateIncidente(Integer idIncidente, String estado, Date actualizadoEn, Integer tiempoResolucionEstimado, Integer tiempoResolucionReal, String consideraciones) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(this.conexionDatabase);
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Incidente incidenteToUpdate = em.find(Incidente.class, idIncidente);

        if (incidenteToUpdate != null) {
            incidenteToUpdate.setEstado(Incidente.Estado.valueOf(estado));
            incidenteToUpdate.setActualizadoEn(actualizadoEn);
            incidenteToUpdate.setTiempoResolucionEstimado(tiempoResolucionEstimado);
            incidenteToUpdate.setTiempoResolucionReal(tiempoResolucionReal);
            incidenteToUpdate.setConsideracionesResolucion(consideraciones);
        } else {
            System.err.println("Incidente no encontrado con el ID proporcionado.");
        }

        em.getTransaction().commit();

        em.close();
        emf.close();
    }

    public void updateIncidente(int idIncidente, String campo, String nuevoValor) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(this.conexionDatabase);
        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();

            String jpql = "UPDATE Incidente i SET i." + campo + " = :nuevoValor WHERE i.id = :idIncidente";

            Query query = em.createQuery(jpql);
            query.setParameter("nuevoValor", nuevoValor);
            query.setParameter("idIncidente", idIncidente);

            int filasActualizadas = query.executeUpdate();

            transaction.commit();

            System.out.println("Se actualizaron " + filasActualizadas + " filas.");
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            System.err.println("Error al actualizar el incidente.");
        } finally {
            em.close();
            emf.close();
        }
    }

    public void updateServicioProblemaRelacion(int idServicioProblemaRelacion, String campo, String nuevoValor) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(this.conexionDatabase);
        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();

            if (campo.equals("idProblema")) {
                campo = "problema.id";
            } else if (campo.equals("idServicio")) {
                campo = "servicio.id";
            }

            String jpql = "UPDATE ServicioProblemaRelacion s SET s." + campo + " = :nuevoValor WHERE s.id = :idServicioProblemaRelacion";

            Query query = em.createQuery(jpql);
            query.setParameter("nuevoValor", nuevoValor);
            query.setParameter("idServicioProblemaRelacion", idServicioProblemaRelacion);

            int filasActualizadas = query.executeUpdate();

            transaction.commit();

            System.out.println("Se actualizaron " + filasActualizadas + " filas.");
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.err.println("Error al actualizar la relación entre servicio y problema.");
        } finally {
            em.close();
            emf.close();
        }
    }

    // Delete Datos
    public void deleteCliente(Integer idCliente) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(this.conexionDatabase);
        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();

            Cliente clienteToDelete = em.find(Cliente.class, idCliente);

            if (clienteToDelete != null) {
                em.remove(clienteToDelete);
                transaction.commit();
                System.out.println("Cliente eliminado con éxito.");
            } else {
                System.err.println("Cliente no encontrado con el ID proporcionado.");
            }
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.err.println("Error al eliminar el cliente.");
        } finally {
            em.close();
            emf.close();
        }
    }

    public void deleteEspecialidad(Integer idEspecialidad) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(this.conexionDatabase);
        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();

            Especialidad especialidadToDelete = em.find(Especialidad.class, idEspecialidad);

            if (especialidadToDelete != null) {
                em.remove(especialidadToDelete);
                transaction.commit();
                System.out.println("Especialidad eliminada con éxito.");
            } else {
                System.err.println("Especialidad no encontrada con el ID proporcionado.");
            }
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.err.println("Error al eliminar la especialidad.");
        } finally {
            em.close();
            emf.close();
        }
    }

    public void deleteOperador(Integer idOperador) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(this.conexionDatabase);
        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();

            Operador operadorToDelete = em.find(Operador.class, idOperador);

            if (operadorToDelete != null) {
                em.remove(operadorToDelete);
                transaction.commit();
                System.out.println("Operador eliminado con éxito.");
            } else {
                System.err.println("Operador no encontrado con el ID proporcionado.");
            }
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.err.println("Error al eliminar el operador.");
        } finally {
            em.close();
            emf.close();
        }
    }

    public void deleteProblema(Integer idProblema) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(this.conexionDatabase);
        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();

            Problema problemaToDelete = em.find(Problema.class, idProblema);

            if (problemaToDelete != null) {
                em.remove(problemaToDelete);
                transaction.commit();
                System.out.println("Problema eliminado con éxito.");
            } else {
                System.err.println("Problema no encontrado con el ID proporcionado.");
            }
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.err.println("Error al eliminar el problema.");
        } finally {
            em.close();
            emf.close();
        }
    }

    public void deleteServicio(Integer idServicio) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(this.conexionDatabase);
        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();

            Servicio servicioToDelete = em.find(Servicio.class, idServicio);

            if (servicioToDelete != null) {
                em.remove(servicioToDelete);
                transaction.commit();
                System.out.println("Servicio eliminado con éxito.");
            } else {
                System.err.println("Servicio no encontrado con el ID proporcionado.");
            }
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            System.err.println("Error al eliminar el servicio.");
        } finally {
            em.close();
            emf.close();
        }
    }

    public void deleteTipo(Integer idTipo) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(this.conexionDatabase);
        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();

            Tipo tipoToDelete = em.find(Tipo.class, idTipo);

            if (tipoToDelete != null) {
                em.remove(tipoToDelete);
                transaction.commit();
                System.out.println("Tipo eliminado con éxito.");
            } else {
                System.err.println("Tipo no encontrado con el ID proporcionado.");
            }
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.err.println("Error al eliminar el tipo.");
        } finally {
            em.close();
            emf.close();
        }
    }

    public void deleteIncidente(Integer idIncidente) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(this.conexionDatabase);
        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();

            Incidente incidenteToDelete = em.find(Incidente.class, idIncidente);

            if (incidenteToDelete != null) {
                em.remove(incidenteToDelete);
                transaction.commit();
                System.out.println("Incidente eliminado con éxito.");
            } else {
                System.err.println("Incidente no encontrado con el ID proporcionado.");
            }
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.err.println("Error al eliminar el incidente.");
        } finally {
            em.close();
            emf.close();
        }
    }

    public void deleteServicioProblemaRelacion(Integer idServicioProblemaRelacion) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(this.conexionDatabase);
        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();

            ServicioProblemaRelacion relacionToDelete = em.find(ServicioProblemaRelacion.class, idServicioProblemaRelacion);

            if (relacionToDelete != null) {
                em.remove(relacionToDelete);
                transaction.commit();
                System.out.println("Relación Servicio-Problema eliminada con éxito.");
            } else {
                System.err.println("Relación Servicio-Problema no encontrada con el ID proporcionado.");
            }
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.err.println("Error al eliminar la relación Servicio-Problema.");
        } finally {
            em.close();
            emf.close();
        }
    }
}
