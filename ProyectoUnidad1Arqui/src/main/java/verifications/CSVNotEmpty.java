package verifications;

import java.util.ArrayList;


public class CSVNotEmpty extends BaseMiddleware<ArrayList<ArrayList<String>>> implements CSVutilities {
    @Override
    public boolean check(ArrayList<ArrayList<String>> info) {
        for (ArrayList<String> linea : info) {
            if(!(linea.size()==2) || CSVutilities.getFirstLineElement(linea).isEmpty() || CSVutilities.getSecondLineElement(linea).isEmpty() ){
                return false;
            }   
        }
        return checkNext(info);
    }
}