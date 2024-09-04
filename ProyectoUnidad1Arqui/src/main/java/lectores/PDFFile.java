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
public class PDFFile implements FileDataLoader<ArrayList<String>>{

    @Setter @Getter private String filePath;

    @Override
    public ArrayList<String> read()  {
        try (PDDocument document = PDDocument.load(new File(this.filePath))) {
            PDFTextStripper stripper = new PDFTextStripper();
            stripper.setSortByPosition(true);
            String PDFtext = stripper.getText(document);
            String[] arrayLines = PDFtext.split(System.lineSeparator());
            return new ArrayList<>(Arrays.asList(arrayLines));
        } catch (IOException e) {
            return null;
        }
    }
    
    
}
