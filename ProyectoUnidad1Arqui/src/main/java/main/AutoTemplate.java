package main;

import java.util.ArrayList;

public class AutoTemplate {

    public void start(String absolutePathPDFFile, String absolutePathCSVFile, String absolutePathOutDir) {
        
        DataRecovery proc = new DataRecovery();
        proc.execute(absolutePathPDFFile, absolutePathCSVFile);

        ArrayList<String> PDFFileData = proc.getDataFilePDF();
        ArrayList<ArrayList<String>> CSVFileData = proc.getDataFileCSV();

        Verifications verifications = new Verifications(PDFFileData, CSVFileData,new ArrayList());

        if (Verifications.BusinessRules()) {

            Template plt = new Template(CSVFileData, PDFFileData);
            plt.fill();

            System.out.println("PROGRAM END");
        } else {
            System.out.println("ERROR");
        }

    }
}
