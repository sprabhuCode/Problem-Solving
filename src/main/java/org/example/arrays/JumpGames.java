package org.example.arrays;

public class JumpGames {

    /**
     You are given an integer array nums.
     You are initially positioned at the array's first index,
     and each element in the array represents your maximum jump length at that position.
     Return true if you can reach the last index, or false otherwise.
     */
    private static boolean canJump1(int[] nums) {
        int max = 0;

        for(int i=0;i<nums.length;i++){
            if(max < i) return false;

            if(nums[i]>0) {
                max = Math.max(max, nums[i]+i);
            }
            if(max >= nums.length-1) return true;
        }
        return false;

    }

    /**
     * You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
     * Each element nums[i] represents the maximum length of a forward jump from index i.
     * In other words, if you are at nums[i], you can jump to any nums[i + j] where:
     * 0 <= j <= nums[i] and
     * i + j < n
     * Return the minimum number of jumps to reach nums[n - 1].
     */

    private static int canJump2(int[] nums) {
            int max = 0;
            int curMax = 0;
            int jump = 0;

            for(int i=0;i<nums.length;i++) {
                if(i>curMax){
                    jump++;
                    curMax = max;
                }
                max = Math.max(max, i+nums[i]);
            }
            return jump;
    }

    public static void main(String[] args) {
        System.out.println("Can jump to the last index = " + canJump1(new int[]{3,2,0,1,1,4}));

        System.out.println("Minimum jumps to reach last index = " + canJump2(new int[]{2,3,1,1,4}));
    }
}
