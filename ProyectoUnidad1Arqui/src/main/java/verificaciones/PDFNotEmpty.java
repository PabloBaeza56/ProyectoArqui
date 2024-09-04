package verificaciones;

import java.util.ArrayList;

public class PDFNotEmpty extends BaseMiddleware<ArrayList<String>> {

    @Override
    public boolean check(ArrayList<String> info) {
        // TODO
        System.out.println("PDF_ContieneTextoBasico");
        return checkNext(info);
    }
}
