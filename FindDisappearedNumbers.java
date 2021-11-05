import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
//https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/
//题目思想来源于map集合。把集合本身当作一个map节省了大量的空间。遍历集合中的数时同时把下标加上length。这样不会覆盖原本的额值，只需要取余即可。
//没有被覆盖的值会小于length即为答案
public class FindDisappearedNumbers {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int x=(nums[i]-1)%nums.length;
            nums[x]+=nums.length;
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=nums.length){
                res.add(i+1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(nums));
    }
}
