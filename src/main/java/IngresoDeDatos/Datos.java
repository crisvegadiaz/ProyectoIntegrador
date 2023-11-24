package IngresoDeDatos;

public class Datos {

    public static void main(String[] args) {

        IngresoDatabase database = new IngresoDatabase("proyecto_integrador");
        
        database.ingresoDatosProblema(8, "un incendio en el almacen de suministros");
    }
}
