package verifications;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

public class TXTCorrectSintaxis extends BaseMiddleware<ArrayList<String>> {

    @Getter @Setter ArrayList<String> tags;

    @Override
    public boolean check(ArrayList<String> info) {
        int counterOpening = 0; 
        int counterEnding = 0;   

        for (String chain : info) {
            for (char c : chain.toCharArray()) {
                if (c == '<') {
                    counterOpening++;
                } else if (c == '>') {
                    counterEnding++;   
                }
            }
        }

        if (counterOpening != counterEnding){
            return false;
        }

        return checkNext(info);
    }
}