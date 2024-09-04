package main;

import java.util.ArrayList;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Template {
    
    private final ArrayList<ArrayList<String>> dataFileCSV;
    private final ArrayList<String> dataFilePDF;

    
    public void fill() {
        boolean isFirstLine = true;
        
        for (ArrayList<String> line : this.dataFileCSV) {
            if (isFirstLine) {
                isFirstLine = false;
                continue;
            }
            ArrayList<String> readyText = this.intercambiarEtiqueta(firstElementInCSVRow(line), secondElementInCSVRow(line));
            this.writeFile(readyText);
        }
    }
    
    private ArrayList<String> intercambiarEtiqueta(String destinatario, String remitente) {
        ArrayList<String> outData = new ArrayList<>(this.dataFilePDF);
        for (int i = 0; i < outData.size(); i++) {
            String line = outData.get(i);
            
            if (line.contains("<destinatario>")) {
                line = line.replace("<destinatario>", destinatario);
            }
            if (line.contains("<remitente>")) {
                line = line.replace("<remitente>", remitente);
            }
            outData.set(i, line);
        }
        return outData;
    }
    
    private String firstElementInCSVRow(ArrayList<String> linea) {
        return linea.get(0);
    }
    
    private String secondElementInCSVRow(ArrayList<String> linea) {
        return linea.get(1);
    }
    
    private void writeFile(ArrayList<String> texto) {
        System.out.println(texto);
        //Tener en cuenta directorio de salida
    }
    
}
