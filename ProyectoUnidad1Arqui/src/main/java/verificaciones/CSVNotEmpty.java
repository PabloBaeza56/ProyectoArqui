package verificaciones;

import java.util.ArrayList;


public class CSVNotEmpty extends BaseMiddleware<ArrayList<ArrayList<String>>> {
    @Override
    public boolean check(ArrayList<ArrayList<String>> info) {
        for (ArrayList<String> linea : info) {
            if(linea.size()<2){
                return false;
            }
            
        }
        System.out.println("CSV_NoVacio");
        return checkNext(info);
    }
}
