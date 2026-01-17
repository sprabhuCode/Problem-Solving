package org.example.arrays;

public class LongestPalindromeString {

    public String longestPalindrome(String s) {
        if(s.length() == 1) {
             return s;
        }

        String ans = "";

        for(int left = 0; left<s.length();left++) {
            for(int right = left ; right < s.length(); right++) {
                if(isPalindrome(s, left, right)){
                    if(ans.length()<(right-left+1)){
                        ans = s.substring(left,right+1);
                    }
                }
            }
        }
        return ans;
    }

    private boolean isPalindrome(String s,  int left, int right) {
        while(left<right){
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
             left++;
             right--;
        }
        return true;
    }
}
