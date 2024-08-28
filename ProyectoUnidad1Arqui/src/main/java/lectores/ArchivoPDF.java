package lectores;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

@AllArgsConstructor
public class ArchivoPDF {

    @Setter @Getter private String rutaArchivo;

    public ArrayList<String> leer() throws PDFInvalidoException {
        try (PDDocument documento = PDDocument.load(new File(this.rutaArchivo))) {
            PDFTextStripper stripper = new PDFTextStripper();
            stripper.setSortByPosition(true);
            String textoPDF = stripper.getText(documento);
            String[] lineasArray = textoPDF.split(System.lineSeparator());
            return new ArrayList<>(Arrays.asList(lineasArray));
        } catch (IOException e) {
            throw new PDFInvalidoException(e);
        }
    }
    
    
}
