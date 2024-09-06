package lectores;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class TXTFile implements FileDataLoader<ArrayList<String>>{

    @Setter @Getter private String filePath;

    @Override
    public ArrayList<String> read() {
        ArrayList<String> lines = new ArrayList<>();
         try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line); 
            }
        } catch (IOException e) {
            e.printStackTrace(); 
        }     
        return lines;   
    }
    
}
