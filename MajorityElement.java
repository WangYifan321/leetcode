import java.util.Arrays;
//https://leetcode-cn.com/problems/majority-element/
public class MajorityElement {
    static class Solution1 {//笨方法，一个一个找
        public int majorityElement(int[] nums) {
            Arrays.sort(nums);
            int max=1;
            int tmp=1,result=nums[0];
            for(int i=1;i<nums.length;i++){
                if(nums[i]==nums[i-1]){
                    tmp++;
                }else{
                    tmp=1;
                }
                if(tmp>max){
                    max=tmp;
                    result=nums[i];
                }

            }
            return result;
        }
    }

    static class Solution2 {//投票法
        public int majorityElement(int[] nums) {
            int count = 0;
            Integer candidate = null;

            for (int num : nums) {
                if (count == 0) {
                    candidate = num;
                }
                count += (num == candidate) ? 1 : -1;
            }

            return candidate;
        }
    }

    static class Solution3 {//因为题目说是大于n/2的一个数，所以排序后，中间的数一定是众数
        public int majorityElement(int[] nums) {
            Arrays.sort(nums);
            return nums[nums.length/2];

        }
    }


}
