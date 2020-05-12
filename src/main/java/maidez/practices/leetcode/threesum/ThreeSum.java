package maidez.practices.leetcode.threesum;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        nums = Arrays.stream(nums).sorted().toArray();
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0 || (i >= 1 && nums[i] == nums[i - 1])) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (k > j && nums[k] == nums[k + 1]) k--;
                } else if (sum < 0) {
                    j++;
                    while (j < k && nums[j] == nums[j - 1]) j++;
                } else {
                    k--;
                    while (k < nums.length - 1 && k > j && nums[k] == nums[k + 1]) k--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        System.out.println(JSON.toJSONString(threeSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4})));
        System.out.println(JSON.toJSONString(threeSum.threeSum(new int[]{0, 0, 0, 0, 0})));
        System.out.println(JSON.toJSONString(threeSum.threeSum(new int[]{-2, 0, 0, 2, 2})));
    }
}
