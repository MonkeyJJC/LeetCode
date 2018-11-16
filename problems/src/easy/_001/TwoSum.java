package easy._001;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> eleIndexMap = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            int targetNum = target - nums[i];
            if (eleIndexMap.containsKey(targetNum)) {
                return new int[]{eleIndexMap.get(targetNum), i};
            }
            eleIndexMap.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        System.out.printf(Arrays.toString(new TwoSum().twoSum(nums, target)));
    }
}
