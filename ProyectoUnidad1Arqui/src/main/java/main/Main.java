package main;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ObtencionDatos proc = new ObtencionDatos();
        
        String rutaPDF = proc.seleccionarArchivo("PDF");
        // System.out.println(rutaPDF);
        String rutaCSV = proc.seleccionarArchivo("CSV");
        // System.out.println(rutaCSV);
        
        if (rutaPDF != null && rutaCSV != null) {
            proc.ejecutar(rutaPDF, rutaCSV);

            ArrayList<String> datosArchivoPDF = proc.getDatosArchivoPDF();
            ArrayList<ArrayList<String>> datosArchivoCSV = proc.getDatosArchivoCSV();

            if (Verificaciones.ReglasNegocio(datosArchivoPDF, datosArchivoCSV)) {
                Plantilla plt = new Plantilla(datosArchivoCSV, datosArchivoPDF);
                plt.rellenar();

                System.out.println("FIN PROGRAMA");
            } else {
                System.out.println("Archivos erroneos");
            }
        } else {
            System.out.println("No se seleccionaron archivos.");
        }
    }
}
