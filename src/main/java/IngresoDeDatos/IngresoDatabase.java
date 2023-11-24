package IngresoDeDatos;

import TablasSQL.Cliente;
import TablasSQL.Especialidad;
import TablasSQL.Operador;
import TablasSQL.Problema;
import TablasSQL.Servicio;
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

    public void ingresoDatosCliente(String nombre, String cuit, String direccion, String email, String telefono) {

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

    public void ingresoDatosEspecialidad(String especialidad, String descripcion) {

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

    public void ingresoDatosOperador(String nombre, String email, String metodoPreferido) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(this.conexionDatabase);
        EntityManager em = emf.createEntityManager();

        // Crear una nueva transacción
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        try {
            // Crear una instancia de Especialidad
            Operador nuevaOperador = new Operador();
            nuevaOperador.setNombre(nombre);
            nuevaOperador.setCorreoElectronico(email);
            nuevaOperador.setMetodoPreferidoNotificacion(metodoPreferido);

            // Persistir la nueva especialidad
            em.persist(nuevaOperador);

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

    public void ingresoDatosProblema(Integer gravedad, String descripcion) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(this.conexionDatabase);
        EntityManager em = emf.createEntityManager();

        // Crear una nueva transacción
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        try {
            // Crear una instancia de Especialidad
            Problema nuevoProblema = new Problema();
            nuevoProblema.setGravedad(gravedad);
            nuevoProblema.setDescripcion(descripcion);

            // Persistir la nueva especialidad
            em.persist(nuevoProblema);

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

    public void ingresoDatosServicio(String nombre, Integer id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(this.conexionDatabase);
        EntityManager em = emf.createEntityManager();

        // Crear una nueva transacción
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        try {

            int idEspecialidadExistente = id;
            Especialidad especialidadExistente = em.find(Especialidad.class, idEspecialidadExistente);
            
            if (especialidadExistente != null) {
                // Crear una instancia de Especialidad
                Servicio nuevoServicio = new Servicio();
                nuevoServicio.setNombre(nombre);
                nuevoServicio.setEspecialidad(especialidadExistente);

                // Persistir la nueva especialidad
                em.persist(nuevoServicio);

                // Commit de la transacción
                transaction.commit();

                System.out.println("Especialidad guardada con éxito.");
            } else {
                System.out.println("Especialidad no encontrada con el ID proporcionado.");
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

}
