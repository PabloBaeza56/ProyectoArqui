package main;

import java.util.ArrayList;
import verificaciones.BaseMiddleware;
import verificaciones.CSVNotEmpty;
import verificaciones.Middleware;
import verificaciones.PDFNotEmpty;
import verificaciones.PDFContainsBasicText;
import verificaciones.Server;

public class Verifications {
    
    public static Boolean BusinessRules(ArrayList<String> dataPDF,ArrayList<ArrayList<String>> dataCSV ){
        return dataPDF != null && dataCSV != null && verificacionesPDF(dataPDF)&& verificacionesCSV(dataCSV);
    }

    private static Boolean verificacionesPDF(ArrayList<String> dataPDF) {
        Server<ArrayList<String>> server = new Server();

        Middleware validacionesPDF = BaseMiddleware.link(// verificar que sea diferente de nulo
                
                new PDFContainsBasicText(),
                new PDFNotEmpty()
        );
        server.setMiddleware(validacionesPDF);

        return server.ejecutar(dataPDF);
    }

    private static Boolean verificacionesCSV(ArrayList<ArrayList<String>> dataCSV) {
        Server<ArrayList<ArrayList<String>>> server = new Server();

        Middleware validacionesCSV = BaseMiddleware.link(// verificar que sea diferente de nulo
                
                new CSVNotEmpty()
        );
        server.setMiddleware(validacionesCSV);

        return server.ejecutar(dataCSV);
    }

}
