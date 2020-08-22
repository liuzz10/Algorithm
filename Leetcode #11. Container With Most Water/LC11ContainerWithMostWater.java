package Leetcode;

//Java
class Solution {
    public int maxArea(int[] height) {
        //Initialize pointers and max
        int maxArea = -1; //JS: int => let
        int i = 0; //JS: int => let
        int j = height.length-1; //JS: int => let

        //Loop for pointers
        while (i < j) {
            int area = (j-i)*Math.min(height[i], height[j]); //JS: int => let
            maxArea = Math.max(maxArea, area);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxArea;
    }
}

//Javascript
var maxArea = function(height) {
    let max = -1;
    let i = 0;
    let j = height.length-1;

    while (i < j) {
        let area = Math.min(height[i], height[j])*(j-i);
        max = Math.max(area, max);
        if (height[i] < height[j]) {
            i++;
        } else {
            j--;
        }
    }
    return max;
};