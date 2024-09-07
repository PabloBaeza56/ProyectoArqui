package verifications;

import java.util.ArrayList;

public class TXTNotEmpty extends BaseMiddleware<ArrayList<String>> {
    
    public ArrayList<String> tags;
    
    public TXTNotEmpty(ArrayList<String> tags){
        this.tags = tags;
    }

    @Override
    public boolean check(ArrayList<String> info) {
        if (info.isEmpty()){
            System.out.println("ERROR -- The file is empty");
            return false;
        }
        
       boolean[] allTagsFound = new boolean[tags.size()];

        for (String line : info) {
            for (int i = 0; i < tags.size(); i++) {
                if (line.contains(tags.get(i))) { 
                    allTagsFound[i] = true;
                }
            }
        }

        for (boolean tag : allTagsFound) {
            if (!tag) {
                System.out.println("ERROR -- No all identifiers used");
                return false;
            }
        }

        return checkNext(info);
    }
}

