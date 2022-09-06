package leetcode;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        Solution solution = new Solution();
        solution.twoSum(nums, 9);
    }

    public int[] twoSum(int[] nums, int target) {
        int[] arr = nums;
        int[] res = new int[2];
        Arrays.sort(arr);
        int left = 0, right = arr.length - 1;
        while(left < right){
            if(arr[left] + arr[right] == target){
                break;
            } else if(arr[left] + arr[right] > target){
                right--;
            } else {
                left++;
            }
        }
        res[0] = Arrays.asList(nums).indexOf(arr[left]);
        res[1] = Arrays.asList(nums).indexOf(arr[right]);
        return res;
        
    }

}


