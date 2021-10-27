import java.math.*;
import java.util.Arrays;
import java.util.Collections;
//https://leetcode-cn.com/problems/next-permutation/
public class NextPermutation {

    static class Solution{
        public static void swap(int[] nums,int a,int b){
            int tmp=nums[a];
            nums[a]=nums[b];
            nums[b]=tmp;

        }
        public static void reverse(int[] nums,int left,int right){
            while(left<right){
                swap(nums,left,right);
                left++;
                right--;
            }
        }
        public static void nextPermutation(int[] nums){
            if(nums.length>1){
                int i,j=nums.length-1;
                for(i=nums.length-2;i>=0;i--){
                    if(nums[i]<nums[i+1]){
                        break;
                    }
                }
                if(i>=0){
                    for(j=nums.length-1;j>i;j--){
                        if(nums[j]>nums[i]){
                            break;
                        }
                    }
                    swap(nums,i,j);

                }

                reverse(nums,i+1,nums.length-1);
            }
        }

    }

    public static void main(String[] args) {

        int[] nums={1,3,2};
        Solution.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
        for (int num : nums) {
            System.out.println(num);
        }

    }
}

