package main;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        //recibir las cadenas correspondientes a las rutas absolutas
        ObtencionDatos proc = new ObtencionDatos();
        proc.ejecutar("C:\\Users\\pablo\\OneDrive\\Escritorio\\ejemplo.pdf",
                "C:\\Users\\pablo\\OneDrive\\Escritorio\\ejemplo.csv");

        ArrayList<String> datosArchivoPDF = proc.getDatosArchivoPDF();
        ArrayList<ArrayList<String>> datosArchivoCSV = proc.getDatosArchivoCSV();

        if (Verificaciones.ReglasNegocio(datosArchivoPDF, datosArchivoCSV)) {

            Plantilla plt = new Plantilla(datosArchivoCSV, datosArchivoPDF);
            plt.rellenar();

            System.out.println("FIN PROGRAMA");
        } else {
            System.out.println("Archivos erroneos");
        }

    }
}
