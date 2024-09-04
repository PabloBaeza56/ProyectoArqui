package main;

import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import lectores.ArchivoCSV;
import lectores.ArchivoPDF;
import lectores.CSVInvalidoException;
import lectores.PDFInvalidoException;
import lombok.Getter;

public class ObtencionDatos {
    @Getter private ArrayList<ArrayList<String>> datosArchivoCSV;
    @Getter private ArrayList<String> datosArchivoPDF; 

    public void ejecutar(String rutaAbsolutaPDF, String rutaAbsolutaCSV) {
        ArchivoPDF arc = new ArchivoPDF(rutaAbsolutaPDF);
        ArchivoCSV cv = new ArchivoCSV(rutaAbsolutaCSV);
        try {
            this.datosArchivoCSV = cv.leer();
            this.datosArchivoPDF = arc.leer();  
        } catch (CSVInvalidoException  ex) {
            System.out.println("El csv no existe");
            this.datosArchivoCSV = null;
        } catch (PDFInvalidoException ex){
            System.out.println("El pdf no existe");
            this.datosArchivoPDF = null;
        }
    } 
    
    public String seleccionarArchivo(String tipoArchivo) {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter;

        if (tipoArchivo.equals("PDF")) {
            filter = new FileNameExtensionFilter("Archivos PDF", "pdf");
        } else if (tipoArchivo.equals("CSV")) {
            filter = new FileNameExtensionFilter("Archivos CSV", "csv");
        } else {
            filter = new FileNameExtensionFilter("Todos los Archivos", "*");
        }

        fileChooser.setFileFilter(filter);
        int resultado = fileChooser.showOpenDialog(null);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile().getAbsolutePath();
        } else {
            return null;
        }
    }
}
