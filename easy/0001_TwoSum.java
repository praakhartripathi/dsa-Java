/*
Problem: Two Sum
Link: https://leetcode.com/problems/two-sum/
Difficulty: Easy

My Approach:
- Used Brute Force with two nested loops.
- Checked every pair of indices to see if their sum equals target.

Time Complexity: O(n^2)
Space Complexity: O(1)

Notes:
This is my first solved approach. Later I will also add the optimized HashMap solution.
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{};
    }
}
