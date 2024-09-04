package verificaciones;

import java.util.ArrayList;

public class CSVWithHeaders extends BaseMiddleware<ArrayList<ArrayList<String>>> {

    private ArrayList<String> header;
    private ArrayList<ArrayList<String>> info

    public CSVWithHeaders(ArrayList<String> header){
        this.header = header;
    }

    @Override
    public boolean check(ArrayList<ArrayList<String>> info) {
        this.info = info;
        if(!getFirstLineElement(getFirstLineFile()).equals(getFirstLineElement(header)) 
        && getSecondLineElement(getFirstLineFile()).equals(getSecondLineElement(header))){
            return false;
        }
        // TODO
        System.out.println("CSV_ConEncabezados");
        return checkNext(info);
    }

    private ArrayList<String> getFirstLineFile(){
        return this.info.get(0);
    }

    private String getFirstLineElement(ArrayList<String> line){
        return line.get(0);
    }

    private String getSecondLineElement(ArrayList<String> line){
        return line.get(1);
    }
}
