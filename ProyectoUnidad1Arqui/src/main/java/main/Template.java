package main;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Template {
    
    private final ArrayList<ArrayList<String>> dataFileCSV;
    private final ArrayList<String> dataFileTXT;
    private final ArrayList<String> tags;
    private String directorio;

    
    public void fill() {
        boolean isFirstLine = true;
        
        for (ArrayList<String> line : this.dataFileCSV) {
            if (isFirstLine) {
                isFirstLine = false;
                continue;
            }
            ArrayList<String> readyText = this.intercambiarEtiqueta(firstElementInCSVRow(line), secondElementInCSVRow(line));
            this.writeFile(readyText,this.directorio);
        }
    }
    
    private ArrayList<String> intercambiarEtiqueta(String tag1, String tag2) {
        ArrayList<String> outData = new ArrayList<>(this.dataFileTXT);
        for (int i = 0; i < outData.size(); i++) {
            String line = outData.get(i);
            
            if (line.contains(firstTag())) {
                line = line.replace(firstTag(), tag1);
            }
            if (line.contains(secondTag())) {
                line = line.replace(secondTag(), tag2);
            }
            outData.set(i, line);
        }
        return outData;
    }

    private String firstTag(){
        return "<"+this.tags.get(0)+">";
    }
    
    private String secondTag(){
        return "<"+this.tags.get(1)+">";
    }

    private String firstElementInCSVRow(ArrayList<String> linea) {
        return linea.get(0);
    }
    
    private String secondElementInCSVRow(ArrayList<String> linea) {
        return linea.get(1);
    }
    
    private void writeFile(ArrayList<String> texto, String directorio) {
// Crear un documento PDF
        PDDocument documento = new PDDocument();

        // Crear una nueva página en el PDF
        PDPage pagina = new PDPage();
        documento.addPage(pagina);

        try {
            PDPageContentStream contenidoStream = new PDPageContentStream(documento, pagina);

            contenidoStream.setFont(PDType1Font.HELVETICA, 12);

            float alturaPagina = pagina.getMediaBox().getHeight();
            float margenSuperior = 100;  

            // Mover el cursor a la esquina superior izquierda
            contenidoStream.beginText();
            contenidoStream.newLineAtOffset(20, alturaPagina - margenSuperior);  // Posición x = 20, y = altura de la página - margen
            
            for (String linea : texto) {
                contenidoStream.showText(linea);
                contenidoStream.newLineAtOffset(0, 12); 
            }

            contenidoStream.endText();
            contenidoStream.close();

            documento.save(directorio);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (documento != null) {
                    documento.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(texto);
    }
    
}
