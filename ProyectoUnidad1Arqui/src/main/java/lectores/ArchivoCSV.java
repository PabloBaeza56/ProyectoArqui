package lectores;

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
public class ArchivoCSV {

    @Setter
    @Getter
    private String rutaArchivo;

    public ArrayList<ArrayList<String>> leer() throws CSVInvalidoException {
        ArrayList<ArrayList<String>> lineas = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(this.rutaArchivo))) {
            String[] linea;
            while ((linea = reader.readNext()) != null) {
                ArrayList<String> listaLinea = new ArrayList<>(Arrays.asList(linea));
                lineas.add(listaLinea);
            }
            return lineas;
        } catch (IOException | CsvValidationException e) {
            throw new CSVInvalidoException(e);
        }

    }

    public void impresionPrueba() {
        try {
            ArrayList<ArrayList<String>> lineas = this.leer();
            for (ArrayList<String> linea : lineas) {
                for (String campo : linea) {
                    System.out.print(campo + " ");
                }
                System.out.println();
            }
        } catch (CSVInvalidoException ex) {
        }
    }

}
