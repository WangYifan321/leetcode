//双指针
public class containerWithMostWater {

    public static int maxArea(int[] height){
        int max = 0;
        int front = 0, end = height.length-1;
        while(front != end){

            if(height[front] >= height[end]){
                int area = (end-front)*height[end];
                if(area > max){
                    max = area;
                }
                end--;
            }else{
                int area = (end-front)*height[front];
                if(area > max){
                    max = area;
                }
                front++;
            }
        }
        return max;

    }

    public static void main(String[] args) {
        int[] a = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(a));
    }
}
