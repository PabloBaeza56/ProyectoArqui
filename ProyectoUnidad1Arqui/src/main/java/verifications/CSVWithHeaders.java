package verifications;

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
            System.out.println("ERROR -- The CSV Headers are incorrect");
            return false;
        }
        if (info.size() <= 1){
            System.out.println("ERROR -- Not info in CSV");
            return false;
        }
        
        
        return checkNext(info);
    }

    private ArrayList<String> getFirstLineFile(){
        return this.info.get(0);
    }

}
