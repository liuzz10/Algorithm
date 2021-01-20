package Leetcode;

//错误一：
class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int k = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                if (k > 0) {
                    i+=2;
                    nums[i] = nums[j];
                } else {
                    i++;
                    nums[i] = nums[j];
                }
            } else {
                k++;
            }
        }
        return i+1;
    }
}

//正确
class Solution {
    public int removeDuplicates(int[] nums) {
        //Set up pointer i to mark the last safe number. Initialize it to 0 to start from the first number.
        int i = 0;
        //Set up counter k to count the ordinal of duplicates. Initialize it to 1 to denote the "kth" time that we see a number.
        int k = 1;

        //Create a loop where j can traverse all numbers in the array, except the first number (because we use 2 pointers so the first number has been represented by i=0)
        for (int j = 1; j < nums.length; j++) {
            //When nums[i] == nums[j], we have found a duplicate number. Maybe it's safe if it's a 2nd-time safe number. So we use k to count the ordinal of this duplicate.
            if (nums[i] == nums[j]) {
                k++;

                //Pointer i moves by 1 when we found a 2nd-time safe number. We assign that value to nums[i+1].
                if (k == 2) {
                i++;
                nums[i] = nums[j];
            }
            //We don't do anything if k>=3. Pointer i wait for j finding a safe number.
            //When nums[i] != nums [j], pointer i moves by 1 since we found a different number - a 1st-time safe number. We assign that value to nums[i+1].
            } else {
                k = 1;
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }
}

//正确的简化版
class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int k = 1;

        for (int j = 1; j < nums.length; j++) {
            if (nums[i] == nums[j]) {
                k++;

                if (k == 2) {
                    i++;
                    nums[i] = nums[j];
                }
            } else {
                k = 1;
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }
}

//无计数器
class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (i < 1 || nums[j] != nums[i-1]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }
}