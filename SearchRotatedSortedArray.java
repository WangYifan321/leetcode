public class SearchRotatedSortedArray {
/*
示例 1：
输入：nums = [4,5,6,7,0,1,2], target = 0
输出：4
示例 2：
输入：nums = [4,5,6,7,0,1,2], target = 3
输出：-1
示例 3：
输入：nums = [1], target = 0
输出：-1
https://leetcode-cn.com/problems/search-in-rotated-sorted-array
* */
    static class Solution {
        public int search(int[] nums, int target) {
            for(int i=0;i<nums.length;i++){
                if(target==nums[i]){
                    return i;
                }
            }
            return -1;
        }
        //二分法
        public int search2(int[] nums, int target) {
            int n=nums.length;
            if(n==0){
                return -1;
            }
            if(n==1){
                return nums[0]==target ? 0: -1;
            }
            int l=0,r=n-1;
            while(l<=r){
                int mid = (l+r)/2;
                if(nums[mid]==target){
                    return mid;
                }
                if(nums[0]<=nums[mid]){
                    if(nums[0]<=target && nums[mid]>target){
                        r=mid-1;
                    }else{
                        l=mid+1;
                    }
                }else{
                    if(nums[mid]<target && target<=nums[n-1]){
                        l=mid+1;
                    }else{
                        r=mid-1;
                    }
                }
            }
            return -1;
        }
    }
}
