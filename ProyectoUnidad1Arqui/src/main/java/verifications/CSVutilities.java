package verifications;

import java.util.ArrayList;

public interface CSVutilities {

    public static String getFirstLineElement(ArrayList<String> line){
        return line.get(0);
    }

    public static String getSecondLineElement(ArrayList<String> line){
        return line.get(1);
    }

    
}
