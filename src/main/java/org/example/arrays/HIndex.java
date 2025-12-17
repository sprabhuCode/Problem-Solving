package org.example.arrays;

import java.util.Arrays;

public class HIndex {
    /**
     * Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper,
     * return the researcher's h-index.
     *
     * According to the definition of h-index on Wikipedia: The h-index is defined as the maximum value of h such that the given
     * researcher has published at least h papers that have each been cited at least h times.
     * Example 1:
     *
     * Input: citations = [3,0,6,1,5]
     * Output: 3
     * Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively.
     * Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, their h-index is 3.
     * @param citations
     * @return
     */
    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        int low = 0;
        int high = citations.length-1;
        int length = citations.length;
        int max = 0;
        while(low<=high) {
            int mid =  low + (high - low) / 2;
            if(citations[mid]>=length-mid){
                max = length-mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return max;

    }
    public static void main(String[] args) {
        int[] arr = {1,1,3};
        hIndex(arr);

    }
}
