package main;

import java.util.ArrayList;
import verificaciones.BaseMiddleware;
import verificaciones.CSV_ConEncabezados;
import verificaciones.CSV_NoVacio;
import verificaciones.Middleware;
import verificaciones.PDF_ContieneTextoBasico;
import verificaciones.PDF_NoVacio;
import verificaciones.Server;

public class Verificaciones {
    
    public static Boolean ReglasNegocio(ArrayList<String> datosPDF,ArrayList<ArrayList<String>> datosCSV ){
        return datosPDF != null && datosCSV != null && verificacionesPDF(datosPDF)&& verificacionesCSV(datosCSV);
    }

    private static Boolean verificacionesPDF(ArrayList<String> datosPDF) {
        Server<ArrayList<String>> server = new Server();

        Middleware validacionesPDF = BaseMiddleware.link(
                // verificar que sea diferente de nulo
                
                new PDF_NoVacio(),
                new PDF_ContieneTextoBasico()
        );
        server.setMiddleware(validacionesPDF);

        return server.ejecutar(datosPDF);
    }

    private static Boolean verificacionesCSV(ArrayList<ArrayList<String>> datosCSV) {
        Server<ArrayList<ArrayList<String>>> server = new Server();

        Middleware validacionesCSV = BaseMiddleware.link(
                // verificar que sea diferente de nulo
                
                new CSV_NoVacio()
        );
        server.setMiddleware(validacionesCSV);

        return server.ejecutar(datosCSV);
    }

}
