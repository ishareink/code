package com.example.code.algorithm;

/**
 * 快速排序
 */
public class QuickSort {
    public static void opsForQuickSort(int [] nums,int l,int r){
        if(l<r){
            int pos=Partition(nums,l,r);
            opsForQuickSort(nums,l,pos-1);
            opsForQuickSort(nums,pos+1,r);
        }
    }
    public static int Partition(int[] nums,int l,int r){
        int point=nums[r];
        int left=l-1;
        for(int i=l;i<r;i++){
            if(left<r&&nums[i]<=point){
                left++;
                swap(nums,left,i);
            }
        }
        swap(nums,left+1,r);
        return left+1;
    }
    public static void swap(int[] nums,int a,int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }

    public static void main(String[] args) {
        int [] num={1,8,7,5,6,8};
        opsForQuickSort(num,0,num.length-1);
        for (int value:num) {
            System.out.print(value+" ");
        }

    }
}
