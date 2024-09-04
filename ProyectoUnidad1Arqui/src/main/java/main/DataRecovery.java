package main;

import java.util.ArrayList;
import lectores.CSVFile;
import lectores.PDFFile;
import lombok.Getter;

public class DataRecovery {

    @Getter private ArrayList<ArrayList<String>> dataFileCSV;
    @Getter private ArrayList<String> dataFilePDF;

    public void execute(String absoluteRoutePDF, String absoluteRouteCSV) {
        PDFFile arc = new PDFFile(absoluteRoutePDF);
        CSVFile cv = new CSVFile(absoluteRouteCSV);

        this.dataFileCSV = cv.read();
        this.dataFilePDF = arc.read();

    }
}
