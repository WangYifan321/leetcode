import java.util.ArrayList;
import java.util.List;
//https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/solution/dian-hua-hao-ma-de-zi-mu-zu-he-by-leetcode-solutio/
//设为全局变量之后在leetcode上提交会出现list集合不会清空的现象，需要list.clear()一下
public class LetterCombinations {
         static String[] strings = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
         static List<String> list = new ArrayList<>();
         static int len;
         static char[] res;//用来存结果
         static char[] digit;
    public static void letterCombinations(String digits){


        if(digits.equals("")){
        }else{
            digit = digits.toCharArray();
            len=digit.length;
            res=new char[len];
            dfs(0);

        }
    }

    private static void dfs(int x) {//x代表输入x个数字
        if(x==len){
            list.add(new String(res));
        }else {
            int a=digit[x]-'0';
            char[] tmp=strings[a].toCharArray();
            for (char c : tmp) {
                res[x] = c;
                dfs(x + 1);
            }
        }
    }

    public static void main(String[] args) {
        letterCombinations("");
        System.out.println(list);
    }

}
