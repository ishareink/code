package com.example.code.leetcode.codetop;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * 示例 2：
 *
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 * 示例 3：
 *
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 */
public class Pow {
    public double myPow(double x, int n) {
        if(x==0.0f)return 0.0d;
        long b=n;
        if(b<0){
            x=1/x;
            b=-b;
        }
        double res=1.0d;
        while(b>0){
            if((b&1)==1)res*=x;
            x*=x;
            b=b>>1;
        }
        return res;
    }
}
