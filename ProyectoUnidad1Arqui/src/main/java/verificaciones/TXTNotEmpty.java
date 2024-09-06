package verificaciones;

import java.util.ArrayList;

public class TXTNotEmpty extends BaseMiddleware<ArrayList<String>> {

    @Override
    public boolean check(ArrayList<String> info) {
        if (info.isEmpty() || info.size() == 0){
            return false;
        }

        System.out.println("PDF_ContieneTextoBasico");
        return checkNext(info);
    }
}
