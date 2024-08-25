package verificaciones;

import java.util.ArrayList;

public class PDF_NoVacio extends BaseMiddleware<ArrayList<String>> {

    @Override
    public boolean check(ArrayList<String> info) {
        // TODO
        System.out.println("PDF_NoVacio");
        return checkNext(info);
    }
}
