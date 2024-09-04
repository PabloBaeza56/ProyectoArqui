package verificaciones;

import java.util.ArrayList;

public class CSVWithHeaders extends BaseMiddleware<ArrayList<ArrayList<String>>> implements CSVutilities {

    private ArrayList<String> header;
    private ArrayList<ArrayList<String>> info;

    public CSVWithHeaders(ArrayList<String> header){
        this.header = header;
    }

    @Override
    public boolean check(ArrayList<ArrayList<String>> info) {
        this.info = info;
        if(!CSVutilities.getFirstLineElement(getFirstLineFile()).equals(CSVutilities.getFirstLineElement(header)) 
        && CSVutilities.getSecondLineElement(getFirstLineFile()).equals(CSVutilities.getSecondLineElement(header))){
            return false;
        }
        System.out.println("CSV_ConEncabezados");
        return checkNext(info);
    }

    private ArrayList<String> getFirstLineFile(){
        return this.info.get(0);
    }

}
