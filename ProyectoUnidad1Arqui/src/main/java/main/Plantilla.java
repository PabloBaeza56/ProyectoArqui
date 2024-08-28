package main;

import java.util.ArrayList;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Plantilla {
    
    private final ArrayList<ArrayList<String>> datosArchivoCSV;
    private final ArrayList<String> datosArchivoPDF;

    
    public void rellenar() {
        boolean esPrimeraLinea = true;
        
        for (ArrayList<String> linea : this.datosArchivoCSV) {
            if (esPrimeraLinea) {
                esPrimeraLinea = false;
                continue;
            }
            ArrayList<String> textoPreparado = this.intercambiarEtiqueta(primerElementoFilaCSV(linea), segundoElementoFilaCSV(linea));
            this.EscribirArchivo(textoPreparado);
        }
    }
    
    private ArrayList<String> intercambiarEtiqueta(String destinatario, String remitente) {
        ArrayList<String> datosSalida = new ArrayList<>(this.datosArchivoPDF);
        for (int i = 0; i < datosSalida.size(); i++) {
            String linea = datosSalida.get(i);
            
            if (linea.contains("<destinatario>")) {
                linea = linea.replace("<destinatario>", destinatario);
            }
            if (linea.contains("<remitente>")) {
                linea = linea.replace("<remitente>", remitente);
            }
            datosSalida.set(i, linea);
        }
        return datosSalida;
    }
    
    private String primerElementoFilaCSV(ArrayList<String> linea) {
        return linea.get(0);
    }
    
    private String segundoElementoFilaCSV(ArrayList<String> linea) {
        return linea.get(1);
    }
    
    private void EscribirArchivo(ArrayList<String> texto) {
        System.out.println(texto);
        //Tener en cuenta directorio de salida
    }
    
}
