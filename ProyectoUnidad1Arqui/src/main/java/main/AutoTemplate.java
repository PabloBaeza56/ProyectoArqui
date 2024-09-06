package main;

import java.util.ArrayList;

public class AutoTemplate {

    public void start(String absolutePathPDFFile, String absolutePathCSVFile, String absolutePathOutDir) {
        
        DataRecovery proc = new DataRecovery();
        proc.execute(absolutePathPDFFile, absolutePathCSVFile);

        ArrayList<String> TXTFileData = proc.getDataFilePDF();
        ArrayList<ArrayList<String>> CSVFileData = proc.getDataFileCSV();


        ArrayList<String> tags = new ArrayList<>();
        tags.add("destinatario");
        tags.add("remitente");

        Verifications verifications = new Verifications(TXTFileData, CSVFileData,tags); 

        if (verifications.BusinessRules()) {

            Template plt = new Template(CSVFileData, TXTFileData);
            plt.fill();

            System.out.println("PROGRAM END");
        } else {
            System.out.println("ERROR");
        }

    }
}
