package verifications;

import java.util.ArrayList;


public class CSVNotEmpty extends BaseMiddleware<ArrayList<ArrayList<String>>> implements CSVutilities {
    @Override
    public boolean check(ArrayList<ArrayList<String>> info) {
        for (ArrayList<String> linea : info) {
            if(!(linea.size()==2) || CSVutilities.getFirstLineElement(linea).isEmpty() || CSVutilities.getSecondLineElement(linea).isEmpty() ){
                System.out.println("ERROR -- The CSV is malformed");
                return false;
            }   
        }
        return checkNext(info);
    }
}