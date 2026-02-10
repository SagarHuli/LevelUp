/*
I own a parking lot that can hold up to 'n' cars at any given point in time. Each slot is given a number starting at 1 increasing with increasing distance from the entry point in steps of one. I want to create an automated ticketing system that allows my customers to use my parking lot without human intervention.

When a car enters my parking lot, I want to have a ticket issued to the driver. The ticket issuing process includes us documenting the registration number (number plate) and the colour of the car and allocating an available parking slot to the car before actually handing over a ticket to the driver (we assume that our customers are nice enough to always park in the slots allocated to them). The customer should be allocated a parking slot which is nearest to the entry. At the exit the customer returns the ticket which then marks the slot they were using as being available.

Due to government regulation, the system should provide me with the ability to find out:

Registration numbers of all cars of a particular colour.
Slot number in which a car with a given registration number is parked.
Slot numbers of all slots where a car of a particular colour is parked.
We interact with the system via a simple set of commands which produce a specific output. Please take a look at the example below, which includes all the commands you need to support - they're self explanatory. The system should allow input in two ways. Just to clarify, the same codebase should support both modes of input - we don't want two distinct submissions.

It should provide us with an interactive command prompt based shell where commands can be typed in
It should accept a filename as a parameter at the command prompt and read the commands from that file
Example: File
Input (contents of file):
create_parking_lot 6
park KA-01-HH-1234 White
park KA-01-HH-9999 White
park KA-01-BB-0001 Black
park KA-01-HH-7777 Red
park KA-01-HH-2701 Blue
park KA-01-HH-3141 Black
leave 4
status
park KA-01-P-333 White
park DL-12-AA-9999 White
registration_numbers_for_cars_with_colour White
slot_numbers_for_cars_with_colour White
slot_number_for_registration_number KA-01-HH-3141
slot_number_for_registration_number MH-04-AY-1111

Output (to STDOUT)
Created a parking lot with 6 slots
Allocated slot number: 1
Allocated slot number: 2
Allocated slot number: 3
Allocated slot number: 4
Allocated slot number: 5
Allocated slot number: 6
Slot number 4 is free
Slot No. Registration No Colour
1 KA-01-HH-1234 White
2 KA-01-HH-9999 White
3 KA-01-BB-0001 Black
5 KA-01-HH-2701 Blue
6 KA-01-HH-3141 Black
Allocated slot number: 4
Sorry, parking lot is full
KA-01-HH-1234, KA-01-HH-9999, KA-01-P-333
1, 2, 4
6
Not found

Example: Interactive
Assuming a parking lot with 6 slots, the following commands should be run in sequence by typing them in at a prompt and should produce output as described below the command. Note that exit terminates the process and returns control to the shell.

$ create_parking_lot 6
Created a parking lot with 6 slots

$ park KA-01-HH-1234 White
Allocated slot number: 1

$ park KA-01-HH-9999 White
Allocated slot number: 2

$ park KA-01-BB-0001 Black
Allocated slot number: 3

$ park KA-01-HH-7777 Red
Allocated slot number: 4

$ park KA-01-HH-2701 Blue
Allocated slot number: 5

$ park KA-01-HH-3141 Black
Allocated slot number: 6

$ leave 4
Slot number 4 is free

$ status
Slot No. Registration No Colour
1 KA-01-HH-1234 White
2 KA-01-HH-9999 White
3 KA-01-BB-0001 Black
5 KA-01-HH-2701 Blue
6 KA-01-HH-3141 Black

$ park KA-01-P-333 White
Allocated slot number: 4

$ park DL-12-AA-9999 White
Sorry, parking lot is full

$ registration_numbers_for_cars_with_colour White
KA-01-HH-1234, KA-01-HH-9999, KA-01-P-333

$ slot_numbers_for_cars_with_colour White
1, 2, 4

$ slot_number_for_registration_number KA-01-HH-3141
6

$ slot_number_for_registration_number MH-04-AY-1111
Not found

$ exit
 */

public class Sample {
}


/*
Given a list arr[] of everyday temperatures. For each day, the task is to find the count of days remaining for the next day with warmer temperatures.
If there is no such day for which warmer temperature is possible then print -1.


Examples:

Input: arr[] = {73, 74, 75, 71, 69, 72, 76, 73}
Output: {1, 1, 4, 2, 1, 1, -1, -1}
Explanation:


https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/
 */



/*
Sure! Here’s a list of 15 LeetCode problems for you:

1. **Sort Colors** - Problem #75 - https://leetcode.com/problems/sort-colors
    Given an array nums with n objects colored red, white, or blue, sort them in-place
    so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
    We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
    You must solve this problem without using the library's sort function.
    Example 1:
    Input: nums = [2,0,2,1,1,0]
    Output: [0,0,1,1,2,2]

    Approach: Intuition is to keep track of number of 0,1 and 2s in first pass.
                Update the array with tracked numbers in the second pass.

    Optimised approach asks to do this in 1 pass.


2. **Implement Queue using Stacks** - Problem #225
Approach: Using 2 stacks:
        enqueue : push to a stack O(1)
        dequeue : pop all elements one by one and push to another stack. Pop the top and push back all the
                    elements to original stack o(2n)
        peek : pop all elements one by one and push to another stack. Get the top and push back all the
                    elements to original stack o(2n)
        size : stack size O(1)

Here’s a list of 15 random medium-level LeetCode problems for you:

3. **Top K Frequent Elements** - Problem #347
Approach: Build an element frequency map. Use minHeap priority queue to store K elements at any given time
return the pq elements. Compelxity : O(nlogK)


4. **Letter Combinations of a Phone Number** - Problem #17
    Approach : Use a map<number -> list of chars the number represents>. For each input string, recursively
    generate all possible subsequences.
    Should not generate all possible subsequences, we should generate by deciding to pick always the current
    index. Time complexity: 2 power h where h will be the depth of recursion tree



5. **Sort List** - Problem #148
    Required constraints :  O(n logn) time and O(1) memory
    Approach : Copy the linked list elements to an array nd perform merge sort. Build a new linkedlist
    as there is no mention of in-place sort. Complexity: O(n) space and O(nlogn) time

6. **Find Peak Element** - Problem #162
    A peak element is an element that is strictly greater than its neighbors.
    Given a 0-indexed integer array nums, find a peak element, and return its index.
    If the array contains multiple peaks, return the index to any of the peaks.
    You may imagine that nums[-1] = nums[n] = -∞.
    In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.
    Example 2:
    Input: nums = [1,2,1,3,5,6,4]
    Output: 5
    Explanation: Your function can return either index number 1 where the peak element is 2,
    or index number 5 where the peak element is 6.
    You must write an algorithm that runs in O(log n) time

    Approach: Couldn't think of an algorithm better than O(n). Applying binary search would require the array
    to be sorted first.
    https://leetcode.com/problems/find-peak-element/submissions/1725890872


7. **Sliding Window Median** - Problem #480

    Approach : Mainitain a local pq and get the median of the window, move the window every iteration.
    Drawbacks : Every iteration adds k elements and remove k elements. TLE

8. **Next Greater Element I** - Problem #496
    https://leetcode.com/problems/next-greater-element-i/description/
    Desired time complexity : O(m+n)
    Approach : Maintain an value -> index map of first array. Loop through second array and check if the current element is
                greater than the top of the stack, If so, we have found the NGE of that element, pop that number and update
                the result array with the current number(Do this process in loop until cur> stack.peek()).
                Push the current element into stack if it exists in first array.

9. **Minimum Window Substring** - Problem #76
    https://leetcode.com/problems/minimum-window-substring/description/
    Input: s = "ADOBECODEBANC", t = "ABC"
    Approach : populate char count map of t. needCount will be size of t.
    Maintain two variables to keep track of indices of smallest substring containing all chars of t in s.
    For every char in s, check if it exists in t, if so increment haveCount. When haveCount reaches needCount , do this in loop
    until haveCount == needCount -> decrement current char count from sMap. If the charCount in sMap < charCOunt in tMap
    that means we have one less char short, so decrement haveCount.

    Finally return the substring with the indices of lowest length


10. **Find All Anagrams in a String** - Problem #438
    Approach : Use two maps each for s and p charCounts. Populate pMap. Start from 0 and slide the window of size p.length()
    over every iteration, compare maps (using pCount.equals(sCount)) and add i to the result if true.
    If false, decrement the ith charCount in sMap and remove the char if count reaches 0.

    Complexity : Time = O(m+n) Space - O(1)

11. **Rotate Array** - Problem #189
    Approach : To rotate by k steps to the right in place, follow 3 steps :
        reverse elements from 0 to n
        reverse from 0 to k
        reverse from k+1 to n
    Time O(n) space : O(1)

    
12. **Insert Interval** - Problem #57
    Approach : Iterate over the list of intervals. First add all the intervals to the result where the end of current interval
    is less than the start of new interval. Then start to merge the intervals iteratively keeping the min boundary and max boundary
    of the new interval. Add the final interval to the result and return the result.
    Complexity : Time : O(n) Space : O(n)

13. **Container With Most Water** - Problem #11
    Approach : Use two pointers, one at start and one at end. Calculate the area between the two pointers and move the pointer
    with the smaller height inwards. Repeat this process until the pointers meet. Return the maxArea.
    Complexity : Time : O(n) Space : O(1)
    
14. **Binary Tree Level Order Traversal II** - Problem #107
    Approach : Use a queue to store the nodes in level order. Use a stack to store the result. Pop the queue elements and add
    them to the stack. Add the left and right children of the current node to the queue. Repeat this process until the queue
    becomes empty. Pop the stack elements and add them to the result.
    Complexity : Time : O(n) Space : O(n)

15. **Kth Largest Element in an Array** - Problem #215
    Approach : Use a minHeap priority queue to store the k largest elements. Add all elements to the pq and pop the top element
    when the size of pq exceeds k. Return the top element of the pq.
    Complexity : Time : O(nlogk) Space : O(k)

16. **Set Matrix Zeroes** - Problem #73
    Approach : First keep track of the rows and columns that have a 0. Then iterate over the matrix and set
    each zero's row and column to 0.
17. **Product of Array Except Self** - Problem #238

These problems should provide a good mix for your practice! Happy coding!
 */