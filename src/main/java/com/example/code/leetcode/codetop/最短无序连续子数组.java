package com.example.code.leetcode.codetop;

import java.util.ArrayDeque;
import java.util.Deque;

public class 最短无序连续子数组 {
    public static void main(String[] args) {
        int[] num={6,8,10,2,9,15};//0 4 5
        // [2,6,4,8,10,9,15]       1 5 5
        System.out.println(findUnsortedSubarray(num));
    }
    public static int findUnsortedSubarray(int[] nums) {
        // 单调栈从前往后遍历一遍可得到左边界
        // 单调栈从后往前遍历一遍可得到右边界
        Deque<Integer> stack = new ArrayDeque<>();
        int left = nums.length;
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                left = Math.min(left, stack.pop());
            }
            stack.push(i);
        }

        stack.clear();
        int right = -1;
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                right = Math.max(right, stack.pop());
            }
            stack.push(i);
        }
        System.out.println(left);
        System.out.println(right);

        return right - left > 0 ? right - left + 1 : 0;
    }
}
