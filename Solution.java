/**
 @author: Ege Hurturk
 @version: 1.3 
 @since: 10-26-2020
 Description: 
    - Given two arrays, num1, num2, the code first merges these two arrays,
    - Then sort the merged array in ascending order,
    - Then finds the median of the merged array
    - Then prints the median, and num1, num1 arrays
 
Performance: O(log(m+n))
Could be improved
*/

import java.util.Arrays;

class Solution {
    /**
    @param: String[] args: Argv
    */
    public static void main(String[] args) {
      int[] nums1 = { 1, 2, 6, 5, 4, 9 };
      int[] nums2 = { 2, 4, 8, 5, 9, 2 };

      findMedianSortedArrays(nums1, nums2);

      int[] nums3 = {1,2};
      int[] nums4 = {3,4};
      findMedianSortedArrays(nums3, nums4);

      int[] nums5 = {0,0};
      int[] nums6 = {0,0};
      findMedianSortedArrays(nums5, nums6);

      int[] nums7 = {1,2,3,4,99};
      int[] nums8 = {4,5,6,9};
      findMedianSortedArrays(nums7, nums8);
    }


    /**
    @param: int[] nums1: First array
    @param: int[] nums2: Second array
    @return double median: the median of the sorted arrays
    */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        boolean condition = check(nums1, nums2);
        if (condition) {
            return 0.0;
        }
        int[] mergedAndSorted = merge2arrays(nums1, nums2);
        double median = findMedian(mergedAndSorted);
        System.out.println(Arrays.toString(mergedAndSorted) + ", median: " + median);
        return median;
    }
    
    /**
    @param: int[] array
    @return double median: finds the median of a given array (the merged one in this problem)
    */
    // ISSUE: #0001 Solved
    public static double findMedian(int[] array) {
        int length = array.length;
        int twoSides = length/2;
        double median = 0.0;
        if (length % 2 != 0) {
            median = array[twoSides];
            return median;
        } 
        double medLeft = array[twoSides];
        double medRight = array[array.length - twoSides - 1];
        median = (medLeft + medRight) / 2;
        return median;
        
    }
    
    /**
    @param: int[] arr1: the first array
    @param: int[] arr2: the second array
    @return int[] sortedArray: merged and sorted array in ascending order
    */
    public static int[] merge2arrays(int[] arr1, int[] arr2) {
        int[] merge = new int[arr1.length + arr2.length];
        for(int i = 0; i < arr1.length; i++) {
            merge[i] = arr1[i];
        }
        for(int j = 0; j < arr2.length; j++) {
            merge[merge.length - j - 1] = arr2[j];
        }
        int[] sortedArray = sortArray(merge);
        return sortedArray;
    }
    
    /**
    @param: int[] array: unsorted array
    @return int[] array: the sorted array in ascending order
    @see {@code merge2arrays}
    */
    public static int[] sortArray(int[] array) {
        int[] raw = array;
        int temp = 0;
        for (int i = 0; i <raw.length; i++) {     
          for (int j = i+1; j <raw.length; j++) {     
              if(raw[i] >raw[j]) {      
                 temp = raw[i];    
                 raw[i] = raw[j];    
                 raw[j] = temp;    
               }     
            }     
        }    
        return raw;
    }
    
    /**
    @param: int[] nums1: the first array
    @param: int[] nums2: the second array
    @return boolean: the condition
    @see {@code findMedianSortedArrays}
    */
    public static boolean check(int[] nums1, int[] nums2) {
        boolean check  = (nums1.length >= 0 && nums1.length <= 1000) && (nums2.length >= 0 && nums2.length <= 1000);
        boolean elemCheck = false;
        for(int i = 0; i < nums1.length; i++) {
            for(int j = 0; j < nums2.length; j++) {
                if (((nums1[i] >= Math.pow(-10, 6)) && (nums1[i] <= Math.pow(10, 6)) )  && ((nums2[j] >= Math.pow(-10, 6)) && (nums2[j] <= Math.pow(10, 6) ))) {
                    elemCheck = true;
                }
            }
        }
        return check && elemCheck;
    }
}

// [1,2,3,4,5,6,7] [5,6,7,8,9]
// merge = new int[12]
// merge = [1,2,3,4,5,6,7]
// merge = [1,2,3,4,5,6,7,9,8,7,6,5]
// merge = [1,2,3,4,5,6,7,9,8,7,6,5]
// sorted = [1,2,3,4,5,5,6,6,7,7,8,9,10]


// ISSUE: 0001: Problem with medRight

