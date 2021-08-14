import java.util.HashSet;
import java.util.Set;
//https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
public class LengthOfLongestSubstring {

    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int len = s.length();
            Set<Character> set = new HashSet<>();
            int right = 0, max = 0;
            for(int i=0; i<len; i++){
                if(i != 0){
                    set.remove(s.charAt(i-1));
                }
                while(right < len && !set.contains(s.charAt(right))){
                    set.add(s.charAt(right));
                    right++;
                }

                max = Math.max(max,right-i);
            }
            return max;

        }
    }
}
