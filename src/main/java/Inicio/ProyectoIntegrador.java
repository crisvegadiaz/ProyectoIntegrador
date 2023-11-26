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

        ingresoDB.ingresoDatosCliente("Cliente 1", "123456789", "Direccion Cliente 1", "cliente1@email.com", "123-456-7890");
        ingresoDB.ingresoDatosCliente("Cliente 2", "223456789", "Direccion Cliente 2", "cliente2@email.com", "223-456-7890");
        ingresoDB.ingresoDatosCliente("Cliente 3", "323456789", "Direccion Cliente 3", "cliente3@email.com", "323-456-7890");
        ingresoDB.ingresoDatosCliente("Cliente 4", "423456789", "Direccion Cliente 4", "cliente4@email.com", "423-456-7890");
        
        ingresoDB.ingresoDatosEspecialidad("Especialidad 1", "Especialidad 1 Desc");
        ingresoDB.ingresoDatosEspecialidad("Especialidad 2", "Especialidad 2 Desc");
        ingresoDB.ingresoDatosEspecialidad("Especialidad 3", "Especialidad 3 Desc");
        ingresoDB.ingresoDatosEspecialidad("Especialidad 4", "Especialidad 4 Desc");
        
        ingresoDB.ingresoDatosOperador("Operador 1", "operador1@email.com","12345678", "Email");
        ingresoDB.ingresoDatosOperador("Operador 2", "operador2@email.com","22345678",  "WhatsApp");
        ingresoDB.ingresoDatosOperador("Operador 3", "operador3@email.com","32345678",  "Email");
        ingresoDB.ingresoDatosOperador("Operador 4", "operador4@email.com","42345678",  "WhatsApp");
        
        ingresoDB.ingresoDatosProblema(1, "Problema 1 Desc");
        ingresoDB.ingresoDatosProblema(2, "Problema 2 Desc");
        ingresoDB.ingresoDatosProblema(9, "Problema 3 Desc");
        ingresoDB.ingresoDatosProblema(6, "Problema 4 Desc");
        
        ingresoDB.ingresoDatosServicio("Servicio 1", 1);
        ingresoDB.ingresoDatosServicio("Servicio 2", 2);
        ingresoDB.ingresoDatosServicio("Servicio 3", 3);
        ingresoDB.ingresoDatosServicio("Servicio 4", 4);
        
        ingresoDB.ingresoDatosTipo("Tipo 1", 140, 1, "Tipo 1 Desc");
        ingresoDB.ingresoDatosTipo("Tipo 2", 240, 2, "Tipo 2 Desc");
        ingresoDB.ingresoDatosTipo("Tipo 3", 240, 3, "Tipo 3 Desc");
        ingresoDB.ingresoDatosTipo("Tipo 4", 140, 4, "Tipo 4 Desc");

        ingresoDB.ingresoDatosIncidente(
                1,
                1, 1,
                1,
                "Abierto",
                new Date(),
                new Date(),
                10,
                25,
                "Consideracion 1"
        );
        
        ingresoDB.ingresoDatosIncidente(
                2,
                2,
                2,
                2,
                "EnProceso",
                new Date(),
                new Date(),
                20,
                10,
                "Consideracion  2"
        );
        ingresoDB.ingresoDatosIncidente(
                3,
                3, 
                3, 3,
                "EnProceso",
                new Date(),
                new Date(),
                6,
                5,
                "Consideracion 3"
        );
        ingresoDB.ingresoDatosIncidente(
                4, 
                4,
                4,
                4,
                "Cerrado",
                new Date(),
                new Date(),
                15,
                12,
                "Consideracion 4"
        );
        
    }

}
