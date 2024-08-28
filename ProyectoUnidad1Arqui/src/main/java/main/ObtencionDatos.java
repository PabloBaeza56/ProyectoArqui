package main;

import java.util.ArrayList;
import lectores.ArchivoCSV;
import lectores.ArchivoPDF;
import lectores.CSVInvalidoException;
import lectores.PDFInvalidoException;
import lombok.Getter;


public class ObtencionDatos {
    @Getter private ArrayList<ArrayList<String>> datosArchivoCSV;
    @Getter private ArrayList<String> datosArchivoPDF; 
    
    public void ejecutar(String rutaAbsolutaPDF, String rutaAbsolutaCSV){
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
}
