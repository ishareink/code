package com.example.code.algorithm;

public class TwoSearch {
    public static int opsForTwoSearch(int num[],int target){
        int left=0;
        int right=num.length-1;
        while(left<=right){
            //[left,right]的中间下标mid
            int mid=left+(right-left)/2;
            if(target>num[mid])left=mid+1;
            else if(target<num[mid])right=mid-1;
            else{
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] num={1,3,5,6,8};
        System.out.println(opsForTwoSearch(num,6));
    }
}
