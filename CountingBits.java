import java.util.ArrayList;
import java.util.Arrays;
//https://leetcode-cn.com/problems/counting-bits/submissions/
//典型动态规划题目。从后往前推理。n-1位时取决与前n-1位。最后一位特殊考虑奇数偶数的情况。。。。
public class CountingBits {
    public static int[] countBits(int n) {
        int[] res = new int[n+1];
        res[0]=0;
        for(int i=0;i<=n;i++){
            if(i%2== 1){
                res[i]=res[i-1]+1;
            }else{
                res[i]=res[i/2];
            }
        }
        return res;


    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(5)));
    }
}
