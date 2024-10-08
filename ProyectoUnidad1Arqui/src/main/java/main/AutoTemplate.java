package main;

import java.util.ArrayList;

public class AutoTemplate {

    public void start(String absolutePathPDFFile, String absolutePathCSVFile, String absolutePathOutDir) {
        
        DataRecovery recover = new DataRecovery();
        recover.execute(absolutePathPDFFile, absolutePathCSVFile);

        ArrayList<String> TXTFileData = recover.getDataFilePDF();
        ArrayList<ArrayList<String>> CSVFileData = recover.getDataFileCSV();

        ArrayList<String> tags = new ArrayList<>();
        tags.add("remitente");
        tags.add("destinatario");

        DataNormalization norma = new DataNormalization();
        ArrayList<String> repairedTXTData = norma.tagNormalization(TXTFileData, tags);
        
        Verifications verifications = new Verifications(repairedTXTData, CSVFileData,tags); 
        if (verifications.BusinessRules()) {

            Template plt = new Template(CSVFileData,repairedTXTData,tags,absolutePathOutDir);
            plt.fill();

            System.out.println("PROGRAM END -- ALL OK");
        } else {
            System.out.println("PROGRAM END -- ERROR");
        }

    }
}
