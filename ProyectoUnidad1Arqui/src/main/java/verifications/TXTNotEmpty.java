package verifications;

import java.util.ArrayList;

public class TXTNotEmpty extends BaseMiddleware<ArrayList<String>> {

    @Override
    public boolean check(ArrayList<String> info) {
        if (info.isEmpty()){
            return false;
        }

        return checkNext(info);
    }
}
