package com.example.code.leetcode.codetop;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * 提示：
 *
 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
 */
public class 滑动窗口的最大值 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null||nums.length==0)return new int[0];
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> queue=new ArrayDeque<>();
        for(int i=0, j=-k+1;i<nums.length;i++,j++){
            //先删除最左 因为要来新值nums[i]
            if(j>=1&&queue.peekFirst()==nums[j-1]){
                queue.removeFirst();
            }
            //后判断是否队列右边的值小于nums[i]，若是就删除队列里的右边
            while(!queue.isEmpty()&&queue.peekLast()<nums[i]){
                queue.removeLast();
            }
            //进队列
            queue.addLast(nums[i]);
            if(j>=0){
                res[j]=queue.peekFirst();
            }
        }
        return res;
    }
}
