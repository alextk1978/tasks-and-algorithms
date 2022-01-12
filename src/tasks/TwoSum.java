package tasks;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Alexey Tkachenko
 * <p>
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * You can return the answer in any order.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 * <p>
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 * <p>
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 */
public class TwoSum {

    public static void main(String[] args) {

        TwoSum twoSum = new TwoSum();

        int[] nums = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum.twoSumOn2(nums, 9)));
        System.out.println(Arrays.toString(twoSum.twoSumOn(nums, 9)));

        int[] nums1 = {3, 2, 4};
        System.out.println(Arrays.toString(twoSum.twoSumOn2(nums1, 6)));
        System.out.println(Arrays.toString(twoSum.twoSumOn(nums1, 6)));

        int[] nums2 = {3, 3};
        System.out.println(Arrays.toString(twoSum.twoSumOn2(nums2, 6)));
        System.out.println(Arrays.toString(twoSum.twoSumOn(nums2, 6)));

        int[] nums3 = {};
        System.out.println(Arrays.toString(twoSum.twoSumOn2(nums3, 6)));
        System.out.println(Arrays.toString(twoSum.twoSumOn(nums3, 6)));

        int[] nums4 = {3, 3};
        System.out.println(Arrays.toString(twoSum.twoSumOn2(nums4, 5)));
        System.out.println(Arrays.toString(twoSum.twoSumOn(nums4, 5)));
    }

    /**
     * Алгоритм со сложностью O(n2).
     */
    public int[] twoSumOn2(int[] nums, int target) {

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    /**
     * Алгоритм со сложностью O(n).
     */
    public int[] twoSumOn(int[] nums, int target) {
        HashMap<Integer, Integer> result = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Integer difference = target - nums[i];
            if (result.containsKey(difference)) {
                return new int[]{result.get(difference), i};
            }
            result.put(nums[i], i);
        }
        return new int[]{};
    }
}
