package com.example.code.leetcode.codetop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 组合总和II {
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res=new ArrayList<>();
        if(candidates.length==0)return res;
        List<Integer> list=new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates,list,0,target);
        return res;
    }

    public void backtrack(int[] num,List<Integer> list,int index,int target){
        if(target==0){
            res.add(new ArrayList<>(list));
            return ;
        }
        //i=index 保证了不重复从同一个索引拿，就保证了组合
        for(int i=index;i<num.length;i++){
            //当当前索引=index就可以选择拿或者不拿
            //当大于index并且当前值和前面值相同 结束当前循环 目的是用顺序拿的概念并且保证遇到重复时不重复组合
            if(i>index&&num[i]==num[i-1])continue;
            //剪支
            if(num[i]>target)break;
            list.add(num[i]);
            backtrack(num,list,i+1,target-num[i]);
            list.remove(list.size()-1);
        }
    }
}
