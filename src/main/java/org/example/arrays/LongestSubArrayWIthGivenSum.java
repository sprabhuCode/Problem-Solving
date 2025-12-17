package org.example.arrays;

public class LongestSubArrayWIthGivenSum {

    /*
    Given an array nums of size n and an integer k,
    find the length of the longest sub-array that sums to k.
    If no such sub-array exists, return 0.
     */
    public static int longestSubarray(int[] nums, int k) {
        int total = 0;
        int startIndex = 0;
        int max = 0;
        for(int i =0; i < nums.length; i++) {
            total += nums[i];
            if(total == k) {
                max = Math.max(max, i - startIndex+1);
            }
            while( startIndex<=i && total > k) {
                total -= nums[startIndex];
                startIndex++;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 1, 9};
        longestSubarray(nums, 10);
    }


}
