package main;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ObtencionDatos proc = new ObtencionDatos();
        proc.ejecutar("C:\\Users\\pablo\\OneDrive\\Escritorio\\ejemplo.pdf",
                "C:\\Users\\pablo\\OneDrive\\Escritorio\\ejemplo.csv");

        if (Verificaciones.verificacionesCSV(proc.getDatosArchivoCSV())
                && Verificaciones.verificacionesPDF(proc.getDatosArchivoPDF())) {
            
            ArrayList<ArrayList<String>> datosArchivoCSV = proc.getDatosArchivoCSV();
            ArrayList<String> datosArchivoPDF = proc.getDatosArchivoPDF();

            //Aqui es la parte cuando ya hacemos el procedimiento solicitado
        } else {
            System.out.println("Archivos erroneos");
        }

    }
}
