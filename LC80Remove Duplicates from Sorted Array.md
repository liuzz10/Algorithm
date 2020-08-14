# Leetcode #80. Remove Duplicates from Sorted Array || Step-by-step explanation (with graph) || Beginner-friendly
## Problem
Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

## Author’s note
This question is asking us to return a “new length”. However, as we know, the array’s length is immutable in Java. It’s actually asking us to REPLACE the duplicate with other “safe” numbers and return the length of the “prefix” of this array. We don’t care what the rest looks like - only make sure the “prefix” is correct.

## Prerequisites
Before solving this question, you should have completed #27. Remove Element and #26. Remove Duplicates from Sorted Array.

## Idea: Counting the duplicate
1. It’s asking us to keep the 1st duplicate number and remove other duplicates if any. If the array is [0, 0, 1, 1, 1, 2, 3, 3], we need to remove the 3rd 1 and keep the rest.
2. Let’s call a number “safe” if it’s our 1st and 2nd time to see it. We call it “unsafe” if we see it more than twice. We need to keep safe numbers and replace the unsafe numbers.
3. Therefore, we need a counter k to count the ordinal of duplicates:
* k=1 means it’s the 1st time we see a certain number. It’s a 1st-time safe number.
* k=2 means it’s the 2nd time we see a certain number. It’s a 2nd-time safe number.
* A safe number can either be a 1st-time safe number or a 2nd-time safe number.
* k=3 means it’s the 3rd time we see a certain number. It’s the first unsafe number that we need to replace.
4. What should be replaced with the unsafe number? The answer is a new safe number.
* We need a pointer j to traverse all numbers to find new safe numbers.
* We also need a pointer i to mark the last safe number.
* Pointer i will wait on its position until pointer i found a new safe number.
5. If you don’t fully understand 1-4, it doesn’t matter. Code will tell the story by itself. Let me explain line by line.

## Iterations graph
![](LC80.jpg)
![](LC80_2.jpg)
