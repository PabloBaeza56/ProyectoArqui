package verificaciones;

import java.util.ArrayList;


public class CSV_NoVacio extends BaseMiddleware<ArrayList<ArrayList<String>>> {
    @Override
    public boolean check(ArrayList<ArrayList<String>> info) {
        // TODO
        System.out.println("CSV_NoVacio");
        return checkNext(info);
    }
}
