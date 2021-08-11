public class singleNumber {
    class Solution {
        public int singleNumber(int[] nums) {
            if(nums == null){
                return 0;
            }
            int single=0;
            for(int num : nums){
                single ^= num;
            }
            return single;
        }
    }
}
//https://leetcode-cn.com/problems/single-number/