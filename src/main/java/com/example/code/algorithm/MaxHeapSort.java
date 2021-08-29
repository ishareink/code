package com.example.code.algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class MaxHeapSort {
    public static void main(String []args){
        int []arr = {7,6,7,11,5,12,3,0,1};
        System.out.println("排序前："+ Arrays.toString(arr));
        Scanner sc=new Scanner(System.in);
        System.out.println("输入top大个数 k");
        int k=sc.nextInt();
        MHsort(arr);
        int[]res=new int [k];
        System.arraycopy(arr,arr.length-k,res,0,k);
        System.out.println("排序前："+Arrays.toString(res));
    }

    private static void MHsort(int[] arr) {
        //构建
        for(int i=arr.length/2-1;i>=0;i--){
            adjustheap(arr,i,arr.length);
        }
        //交换调整
        for(int len=arr.length-1;len>0;len--){
            swap(arr,0,len);
            adjustheap(arr,0,len);
        }

    }
    public static void adjustheap(int[] arr,int start,int len){
        for(int k=start*2+1;k<len;k=2*k+1){
            if(k+1<len&&arr[k]<arr[k+1]){//右子节点的临界&&左节点小于右节点，就指向右节点——说明仅仅调整右子树
                k++;
            }
            if(arr[k]>arr[start]){//子节点大于父节点
                swap(arr,start,k);
                start=k;
            }
            else{
                break;//满足条件就break
            }
        }
    }

    private static void swap(int[] arr,int lo,int hi) {
        int temp=arr[lo];
        arr[lo]=arr[hi];
        arr[hi]=temp;
    }
}
