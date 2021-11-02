import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void moveZeroes(int[] nums) {
        for (int i=0;i<nums.length;i++) {
            if(nums[i]==0){
                for(int j=i+1;j<nums.length;j++){
                    if(nums[j]!=0){
                        int tmp=nums[i];
                        nums[i]=nums[j];
                        nums[j]=tmp;
                        break;
                    }
                }
            }
        }
    }
//最快的方法
//遍历一遍数组，弄一个index下标，遇到非0的就从头给数组赋值，inde++。最后把index后面的补0即可
    public static void moveZeroes2(int[] nums){

        int index = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[index++] = num;
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    //双指针法，
    static class Solution2 {
        public void moveZeroes(int[] nums) {
            int n = nums.length, left = 0, right = 0;
            while (right < n) {
                if (nums[right] != 0) {
                    swap(nums, left, right);
                    left++;
                }
                right++;
            }
        }

        public void swap(int[] nums, int left, int right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
    }

}

