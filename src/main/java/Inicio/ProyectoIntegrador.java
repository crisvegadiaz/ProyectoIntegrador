package Inicio;

import IngresoDeDatos.IngresoDatabase;
import Persistencia.ControladoraPersistencia;
import java.util.Date;

public class ProyectoIntegrador {

    public static void main(String[] args) {
        System.out.println("Proyecto Integrador");

        // Creacion de tablas SQL
        ControladoraPersistencia controlPersis = new ControladoraPersistencia();
        //Datos de Prueba
        IngresoDatabase ingresoDB = new IngresoDatabase("proyecto_integrador");
        
        
        ingresoDB.ingresoDatoCliente("Cliente 1", "123456789", "Direccion Cliente 1", "cliente1@email.com", "123-456-7890");
        ingresoDB.ingresoDatoCliente("Cliente 2", "223456789", "Direccion Cliente 2", "cliente2@email.com", "223-456-7890");
        ingresoDB.ingresoDatoCliente("Cliente 3", "323456789", "Direccion Cliente 3", "cliente3@email.com", "323-456-7890");
        ingresoDB.ingresoDatoCliente("Cliente 4", "423456789", "Direccion Cliente 4", "cliente4@email.com", "423-456-7890");

        ingresoDB.ingresoDatoEspecialidad("Especialidad 1", "Especialidad 1 Desc");
        ingresoDB.ingresoDatoEspecialidad("Especialidad 2", "Especialidad 2 Desc");
        ingresoDB.ingresoDatoEspecialidad("Especialidad 3", "Especialidad 3 Desc");
        ingresoDB.ingresoDatoEspecialidad("Especialidad 4", "Especialidad 4 Desc");

        ingresoDB.ingresoDatoOperador("Operador 1", "operador1@email.com", "12345678", "Email");
        ingresoDB.ingresoDatoOperador("Operador 2", "operador2@email.com", "22345678", "WhatsApp");
        ingresoDB.ingresoDatoOperador("Operador 3", "operador3@email.com", "32345678", "Email");
        ingresoDB.ingresoDatoOperador("Operador 4", "operador4@email.com", "42345678", "WhatsApp");

        ingresoDB.ingresoDatoProblema(1, "Problema 1 Desc");
        ingresoDB.ingresoDatoProblema(2, "Problema 2 Desc");
        ingresoDB.ingresoDatoProblema(9, "Problema 3 Desc");
        ingresoDB.ingresoDatoProblema(6, "Problema 4 Desc");

        ingresoDB.ingresoDatoServicio("Servicio 1", 1);
        ingresoDB.ingresoDatoServicio("Servicio 2", 2);
        ingresoDB.ingresoDatoServicio("Servicio 3", 3);
        ingresoDB.ingresoDatoServicio("Servicio 4", 4);

        ingresoDB.ingresoDatoTipo(1, "Tipo 1", 12, "Tipo 1 Desc", 10);
        ingresoDB.ingresoDatoTipo(2, "Tipo 2", 22, "Tipo 2 Desc", 20);
        ingresoDB.ingresoDatoTipo(3, "Tipo 3", 32, "Tipo 3 Desc", 30);
        ingresoDB.ingresoDatoTipo(4, "Tipo 4", 42, "Tipo 4 Desc", 40);

        ingresoDB.ingresoDatoIncidente(
                1,
                1,
                1,
                1,
                1,
                "Abierto",
                new Date(),
                new Date(),
                10,
                12,
                "No hay"
        );

        ingresoDB.ingresoDatoIncidente(
                2,
                2,
                2,
                2,
                2,
                "EnProceso",
                new Date(),
                new Date(),
                10,
                12,
                "No hay"
        );
        ingresoDB.ingresoDatoIncidente(
                3,
                3,
                3,
                3,
                3,
                "Cerrado",
                new Date(),
                new Date(),
                10,
                12,
                "No hay"
        );
        ingresoDB.ingresoDatoIncidente(
                4,
                4,
                4,
                4,
                4,
                "Abierto",
                new Date(),
                new Date(),
                10,
                12,
                "No hay"
        );
        

        ingresoDB.ingresoDatoServicioProblemaRelacion(1, 1);
        ingresoDB.ingresoDatoServicioProblemaRelacion(2, 2);
        ingresoDB.ingresoDatoServicioProblemaRelacion(3, 3);
        ingresoDB.ingresoDatoServicioProblemaRelacion(4, 4);

    }

}
