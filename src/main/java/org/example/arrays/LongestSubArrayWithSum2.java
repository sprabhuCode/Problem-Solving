package org.example.arrays;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithSum2 {

    /**
     * Given an array and a sum k, we need to print the length of the longest subarray that sums to k.
     * array contains both positive and negative values
     */
    private static int findLongestSubarray(int[] arr, int k) {
        if (arr == null || arr.length == 0) { return 0;}

        Map<Integer,Integer> map = new HashMap<>();
        int max = 0;
        int curSum = 0;
        for(int i=0; i < arr.length; i++) {
            curSum += arr[i];
            if(curSum ==k) {
                max = Math.max(max,i+1);
            } else if(map.containsKey(curSum-k)) {
                max = Math.max(max, i-map.get(curSum-k));
            }
            map.put(curSum,i);
        }
        return max;

    }
    public static void main(String[] args) {
        int[] arr = {6,1,2,3,6,-5,-1,2,6};
        findLongestSubarray(arr, 5);
    }
}
