package com.example.code.leetcode.codetop;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 * 示例 3：
 *
 * 输入：s = "a"
 * 输出："a"
 */
public class 最长回文子串 {
    public String longestPalindrome(String s) {
        int n=s.length();
        if (n < 2) {
            return s;
        }
        //判断索引0到3是否回文 先知道1-2是否回文就可以推断，所以动态规划来做
        boolean[][] dp=new boolean[n][n];
        //左右指针
        int lo=0;
        int hi=0;
        //前面可知，先得到1-2后得到0-3 所以不能01 02 03 而是列遍历 右上三角形 从上到下从左到右 00 01 11 02 12 22 。。。
        for(int j=0;j<n;j++){
            for(int i=0;i<j;i++){
                //单个字符 肯定回文
                if(i==j){
                    dp[i][j]=true;
                }
                //左右指针指向的字符不相同 肯定不是回文
                else if(s.charAt(i)!=s.charAt(j)){
                    dp[i][j]=false;
                }
                //左右指针指向字符相同 并且差距小于3，即012 数量不超过3 是回文
                else if(j-i<3){
                    dp[i][j]=true;
                }
                //左右指针指向字符相同，当前是不是回文由dp[i+1][j-1]决定
                else {
                    dp[i][j]=dp[i+1][j-1];
                }
                //如果当前指向是回文 且长度(j-i)大于专门记录最长回文子串的左右指针差值（就是长度），更新
                if(dp[i][j]&&j-i>hi-lo){
                    lo=i;
                    hi=j;
                }
            }
        }
        return s.substring(lo,hi+1);
    }
}
