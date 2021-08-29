package com.example.code.leetcode.codetop;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 */
public class 接雨水 {
    public int trap(int[] height) {
        int n=height.length;
        int[] max_left=new int[n];
        int[] max_right=new int[n];

        for(int i=1;i<n-1;i++){
            max_left[i]=Math.max(max_left[i-1],height[i-1]);
        }
        for(int i=n-2;i>=1;i--){
            max_right[i]=Math.max(max_right[i+1],height[i+1]);
        }
        int res=0;
        for(int i=1;i<n-1;i++){
            int water=Math.min(max_left[i],max_right[i])-height[i];
            if(water>0){
                res+=water;
            }
        }
        return res;
    }
}
