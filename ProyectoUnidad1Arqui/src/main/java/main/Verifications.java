package main;

import java.util.ArrayList;
import lombok.AllArgsConstructor;
import verifications.BaseMiddleware;
import verifications.CSVNotEmpty;
import verifications.CSVWithHeaders;
import verifications.Middleware;
import verifications.TXTNotEmpty;
import verifications.TXTCorrectSintaxis;
import verifications.Server;
import verifications.TXTCorrectSigns;

@AllArgsConstructor
public class Verifications {
    private final ArrayList<String> dataPDF;
    private final ArrayList<ArrayList<String>> dataCSV;
    private final ArrayList<String> tags;
    
    public Boolean BusinessRules(){
        return this.dataPDF != null && this.dataCSV != null && verificacionesPDF(dataPDF)&& verificacionesCSV(dataCSV);
    }
    
    private Boolean verificacionesPDF(ArrayList<String> dataPDF) {
        Server<ArrayList<String>> server = new Server();
        
        Middleware validacionesPDF = BaseMiddleware.link(
                new TXTCorrectSintaxis(),
                new TXTCorrectSigns(),
                new TXTNotEmpty(tags)
        );
        server.setMiddleware(validacionesPDF);
        return server.executeChain(dataPDF);
    }
    
    private Boolean verificacionesCSV(ArrayList<ArrayList<String>> dataCSV) {
        Server<ArrayList<ArrayList<String>>> server = new Server();

        Middleware validacionesCSV = BaseMiddleware.link(
                new CSVNotEmpty(),
                new CSVWithHeaders(tags)
        );
        server.setMiddleware(validacionesCSV);

        return server.executeChain(dataCSV);
    }
    
 

}
