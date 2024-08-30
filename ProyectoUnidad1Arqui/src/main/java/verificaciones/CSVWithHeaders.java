package verificaciones;

import java.util.ArrayList;

public class CSVWithHeaders extends BaseMiddleware<ArrayList<ArrayList<String>>> {

    @Override
    public boolean check(ArrayList<ArrayList<String>> info) {
        // TODO
        System.out.println("CSV_ConEncabezados");
        return checkNext(info);
    }
}
