/**
 * @author lifubei
 * @date 2020/05/19 11:33
 */
public class Solution {
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{2,7,11,15};
        int target = 9;
        int[] ints1 = twoSum(ints, target);
        System.out.println(ints1);

    }

    public void bug(){
        System.out.println("大哥");
    }
}
