import java.util.ArrayList;
import java.util.List;
//递归回溯https://leetcode-cn.com/problems/generate-parentheses/
public class GenerateParenthesis {
    static class Solution {
        static List<String> result = new ArrayList<>();
        public static List<String> generateParenthesis(int n) {

            if(n<=0){
                return result;
            }
            dfs("",n,n);
            return result;
        }

        static void dfs(String str,int left,int right){
            if(left==0 && right==0){
                result.add(str);
                return;
            }else if(left == right){
                dfs(str+"(",left-1,right);
            }else{
                if(left<right){
                    if(left!=0){
                        dfs(str+"(",left-1,right);
                    }
                    dfs(str+")",left,right-1);
                }
            }
        }

        public static void main(String[] args) {
            System.out.println(generateParenthesis(2));
        }
    }
}
