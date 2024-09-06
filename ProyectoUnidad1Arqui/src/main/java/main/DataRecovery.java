package main;

import java.util.ArrayList;
import readers.CSVFile;
import readers.TXTFile;
import lombok.Getter;


public class DataRecovery {

    @Getter private ArrayList<ArrayList<String>> dataFileCSV;
    @Getter private ArrayList<String> dataFilePDF;

    public void execute(String absoluteRoutePDF, String absoluteRouteCSV) {
        TXTFile arc = new TXTFile(absoluteRoutePDF);
        CSVFile cv = new CSVFile(absoluteRouteCSV);

        this.dataFileCSV = cv.read();
        this.dataFilePDF = arc.read();

    }
}
