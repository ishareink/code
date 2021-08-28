package com.example.code.leetcode.codetop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * 示例 2：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class 全排列II {
    boolean[] state;
    List<List<Integer>> res;
    public List<List<Integer>> permuteUnique(int[] nums) {
        res=new ArrayList<>();
        if(nums.length==0)return res;
        state=new boolean[nums.length];
        List<Integer> list=new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums,list);
        return res;
    }
    //类似二叉树，向下不断分叉，看层数
    public void backtrack(int[] nums,List<Integer> list){
        if(list.size()==nums.length){
            res.add(new ArrayList<>(list));
            return ;
        }
        for(int i=0;i<nums.length;i++){
            //保证遇到重复数时，按照从左到右到顺序拿
            //当获取过当前值nums[i] 或者 当前值等于前面的值并且前面的值没有拿过 结束当前循环
            if(state[i]||i>0&&nums[i]==nums[i-1]&&!state[i-1])continue;
            state[i]=true;
            list.add(nums[i]);
            backtrack(nums,list);
            state[i]=false;
            list.remove(list.size()-1);
        }
    }

}
