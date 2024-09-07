
package verifications;

import dataStructures.Stack;
import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;


public class TXTCorrectSigns extends BaseMiddleware<ArrayList<String>> {

    @Getter @Setter ArrayList<String> tags;

    @Override
    public boolean check(ArrayList<String> info) {
        for (String str : info) {
            Stack<Character> stack = new Stack<>();
            
            for (char ch : str.toCharArray()) {
                if (ch == '<') {
                    stack.push(ch);
                }
                if (ch == '>') {
                    if (stack.isEmpty()) {
                        return false;
                    } else {
                        stack.pop();
                    }
                }
            }
            
            if (!stack.isEmpty()) {
                System.out.println("ERROR -- The sintax of < > is incorrect");
                return false;
            }
        }

        return checkNext(info);
    }
}
