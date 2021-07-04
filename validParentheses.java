import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
//https://leetcode-cn.com/problems/valid-parentheses/
import static javax.swing.UIManager.put;

public class validPparentheses {


    class Solution {
        public boolean isValid(String s) {
            int size = s.length();
            if(size % 2 != 0){
                return false;
            }
            Map<Character, Character> pairs = new HashMap<Character, Character>(){{
                put(')','(');
                put(']','[');
                put('}','{');
            }};
            Deque<Character> stack = new LinkedList<Character>();
            for(int i = 0; i < size; i++){
                char x = s.charAt(i);
                if(pairs.containsKey(x)){
                    if(stack.isEmpty() || stack.peek() != pairs.get(x)) {
                        return false;
                    }
                    stack.pop();
                }else{
                    stack.push(x);
                }
            }

            return stack.isEmpty();

        }
    }
}
