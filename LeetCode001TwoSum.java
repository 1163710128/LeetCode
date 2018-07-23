public class LeetCode001TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int [] result = new int [2];
        for(int i = 0;i < nums.length - 1;i++){
            int D_val = target - nums[i];
            for(int j = i + 1;j < nums.length;j++){
                if(nums[j] == D_val) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return null;
    }
}
