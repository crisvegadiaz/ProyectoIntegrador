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

        // Datos de Clientes
        ingresoDB.createCliente("Cliente A", "123456789", "Dirección Cliente A", "clienteA@email.com", "123-456-7890");
        ingresoDB.createCliente("Cliente B", "223456789", "Dirección Cliente B", "clienteB@email.com", "223-456-7890");
        ingresoDB.createCliente("Cliente C", "323456789", "Dirección Cliente C", "clienteC@email.com", "323-456-7890");
        ingresoDB.createCliente("Cliente D", "423456789", "Dirección Cliente D", "clienteD@email.com", "423-456-7890");
        ingresoDB.createCliente("Cliente E", "523456789", "Dirección Cliente E", "clienteE@email.com", "523-456-7890");
        ingresoDB.createCliente("Cliente F", "623456789", "Dirección Cliente F", "clienteF@email.com", "623-456-7890");
        ingresoDB.createCliente("Cliente G", "723456789", "Dirección Cliente G", "clienteG@email.com", "723-456-7890");
        ingresoDB.createCliente("Cliente H", "823456789", "Dirección Cliente H", "clienteH@email.com", "823-456-7890");
        ingresoDB.createCliente("Cliente I", "923456789", "Dirección Cliente I", "clienteI@email.com", "923-456-7890");
        ingresoDB.createCliente("Cliente J", "123789456", "Dirección Cliente J", "clienteJ@email.com", "123-789-4560");

        // Datos de Especialidades
        ingresoDB.createEspecialidad("Redes", "Especialidad en configuración de redes");
        ingresoDB.createEspecialidad("SAP", "Especialidad en soporte SAP");
        ingresoDB.createEspecialidad("Linux", "Especialidad en sistemas operativos Linux");
        ingresoDB.createEspecialidad("Windows", "Especialidad en sistemas operativos Windows");
        ingresoDB.createEspecialidad("Base de Datos", "Especialidad en administración de bases de datos");
        ingresoDB.createEspecialidad("Seguridad", "Especialidad en seguridad informática");
        ingresoDB.createEspecialidad("Desarrollo", "Especialidad en desarrollo de software");
        ingresoDB.createEspecialidad("Hardware", "Especialidad en soporte de hardware");
        ingresoDB.createEspecialidad("Cloud", "Especialidad en servicios en la nube");
        ingresoDB.createEspecialidad("Virtualización", "Especialidad en virtualización de sistemas");

        // Datos de Operadores
        ingresoDB.createOperador("Operador 1", "operador1@email.com", "12345678", "Email");
        ingresoDB.createOperador("Operador 2", "operador2@email.com", "22345678", "WhatsApp");
        ingresoDB.createOperador("Operador 3", "operador3@email.com", "32345678", "Email");
        ingresoDB.createOperador("Operador 4", "operador4@email.com", "42345678", "WhatsApp");
        ingresoDB.createOperador("Operador 5", "operador5@email.com", "52345678", "WhatsApp");
        ingresoDB.createOperador("Operador 6", "operador6@email.com", "62345678", "Email");
        ingresoDB.createOperador("Operador 7", "operador7@email.com", "72345678", "WhatsApp");
        ingresoDB.createOperador("Operador 8", "operador8@email.com", "82345678", "Email");
        ingresoDB.createOperador("Operador 9", "operador9@email.com", "92345678", "WhatsApp");
        ingresoDB.createOperador("Operador 10", "operador10@email.com", "12378956", "Email");

        // Datos de Problemas
        ingresoDB.createProblema(1, "Problema de conectividad en la red");
        ingresoDB.createProblema(2, "Problema de software en el sistema operativo");
        ingresoDB.createProblema(3, "Error en la aplicación SAP");
        ingresoDB.createProblema(4, "Fallo en el hardware del equipo");
        ingresoDB.createProblema(5, "Vulnerabilidad de seguridad detectada");
        ingresoDB.createProblema(6, "Problema en la configuración de la virtualización");
        ingresoDB.createProblema(7, "Error en la base de datos");
        ingresoDB.createProblema(8, "Problema en el servicio en la nube");
        ingresoDB.createProblema(9, "Error en el código de la aplicación");
        ingresoDB.createProblema(10, "Fallo en el sistema operativo");

        ingresoDB.createProblema(6, "Problema 4 Desc");

        // Datos de Servicios
        ingresoDB.createServicio("Servicio A", 1);
        ingresoDB.createServicio("Servicio B", 2);
        ingresoDB.createServicio("Servicio C", 3);
        ingresoDB.createServicio("Servicio D", 4);
        ingresoDB.createServicio("Servicio E", 5);
        ingresoDB.createServicio("Servicio F", 6);
        ingresoDB.createServicio("Servicio G", 7);
        ingresoDB.createServicio("Servicio H", 8);
        ingresoDB.createServicio("Servicio I", 9);
        ingresoDB.createServicio("Servicio J", 10);

        // Datos de Tipos
        ingresoDB.createTipo(1, "Tipo de Problema 1", 12, "Tipo 1 Desc", 10);
        ingresoDB.createTipo(2, "Tipo de Problema 2", 22, "Tipo 2 Desc", 20);
        ingresoDB.createTipo(3, "Tipo de Problema 3", 32, "Tipo 3 Desc", 30);
        ingresoDB.createTipo(4, "Tipo de Problema 4", 42, "Tipo 4 Desc", 40);
        ingresoDB.createTipo(5, "Tipo de Problema 5", 52, "Tipo 5 Desc", 50);
        ingresoDB.createTipo(6, "Tipo de Problema 6", 62, "Tipo 6 Desc", 60);
        ingresoDB.createTipo(7, "Tipo de Problema 7", 72, "Tipo 7 Desc", 70);
        ingresoDB.createTipo(8, "Tipo de Problema 8", 82, "Tipo 8 Desc", 80);
        ingresoDB.createTipo(9, "Tipo de Problema 9", 92, "Tipo 9 Desc", 90);
        ingresoDB.createTipo(10, "Tipo de Problema 10", 102, "Tipo 10 Desc", 100);

        // Datos de Relación entre Servicio y Problema
        ingresoDB.createServicioProblemaRelacion(1, 1);
        ingresoDB.createServicioProblemaRelacion(2, 2);
        ingresoDB.createServicioProblemaRelacion(3, 3);
        ingresoDB.createServicioProblemaRelacion(4, 4);
        ingresoDB.createServicioProblemaRelacion(5, 5);
        ingresoDB.createServicioProblemaRelacion(6, 6);
        ingresoDB.createServicioProblemaRelacion(7, 7);
        ingresoDB.createServicioProblemaRelacion(8, 8);
        ingresoDB.createServicioProblemaRelacion(9, 9);
        ingresoDB.createServicioProblemaRelacion(10, 10);

        // Datos de Incidentes
        ingresoDB.createIncidente(
                10,
                1,
                1,
                1,
                1,
                "Abierto",
                new Date(2023 - 1900, 10, 26, 9, 30),
                new Date(2023 - 1900, 10, 26, 10, 45),
                10,
                12,
                "No hay"
        );

        ingresoDB.createIncidente(
                9,
                2,
                2,
                2,
                2,
                "EnProceso",
                new Date(2023 - 1900, 10, 26, 11, 15),
                new Date(2023 - 1900, 10, 26, 13, 0),
                10,
                12,
                "No hay"
        );

        ingresoDB.createIncidente(
                8,
                3,
                3,
                3,
                3,
                "Cerrado",
                new Date(2023 - 1900, 10, 26, 14, 20),
                new Date(2023 - 1900, 10, 26, 16, 30),
                10,
                12,
                "No hay"
        );

        ingresoDB.createIncidente(
                1,
                8,
                8,
                1,
                1,
                "Abierto",
                new Date(2023 - 1900, 4, 28, 9, 30),
                new Date(2023 - 1900, 5, 4, 10, 45),
                10,
                8,
                "No hay"
        );

        ingresoDB.createIncidente(
                9,
                2,
                2,
                2,
                2,
                "EnProceso",
                new Date(2023 - 1900, 1, 10, 11, 15),
                new Date(2023 - 1900, 1, 20, 13, 0),
                10,
                12,
                "No hay"
        );

        ingresoDB.createIncidente(
                8,
                3,
                3,
                3,
                3,
                "Cerrado",
                new Date(2023 - 1900, 8, 26, 14, 20),
                new Date(2023 - 1900, 8, 30, 16, 30),
                10,
                12,
                "No hay"
        );

        ingresoDB.createIncidente(
                4,
                2,
                2,
                8,
                3,
                "Cerrado",
                new Date(2023 - 1900, 9, 10, 14, 20),
                new Date(2023 - 1900, 9, 20, 16, 30),
                10,
                12,
                "No hay"
        );

    }

}
