public class HammingDistance {
    //https://leetcode-cn.com/problems/hamming-distance/solution/yi-ming-ju-chi-by-leetcode-solution-u1w7/
    public static int hammingDistance(int x, int y) {
        int count = 0;
        while(x!=0 || y!=0){
            if(x%2 != y%2) count++;
            x>>=1;
            y>>=1;

        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(1,3));
    }
}

//解法一：异或操作之后比特计位1的值   Integer.bitCount(x ^ y);
//解法二：异或之后从后往前统计1的值
//解法三：Brian Kernighan 算法。x&x-1的结果刚好就是把x的最后一个1去掉class Solution {
//    public int hammingDistance(int x, int y) {
//        int s = x ^ y, ret = 0;
//        while (s != 0) {
//            s &= s - 1;
//            ret++;
//        }
//        return ret;
//    }
//}

