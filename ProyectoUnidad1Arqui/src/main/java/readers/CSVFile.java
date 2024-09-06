package readers;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class CSVFile implements FileDataLoader<ArrayList<ArrayList<String>>>{

    @Setter @Getter private String filePath;

    @Override
    public ArrayList<ArrayList<String>> read()  {
        ArrayList<ArrayList<String>> lines = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(this.filePath))) {
            String[] line;
            while ((line = reader.readNext()) != null) {
                ArrayList<String> listaLinea = new ArrayList<>(Arrays.asList(line));
                lines.add(listaLinea);
            }
            return lines;
        } catch (IOException | CsvValidationException e) {
            return null;
        }

    }

}
