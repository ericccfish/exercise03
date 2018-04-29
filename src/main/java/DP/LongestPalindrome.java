package DP;

/**
 * Created by chenjianfeng on 2018/1/29.
 */

/**
 * 最长回文串
 */
public class LongestPalindrome {
    public int longestPalindrome(char[] str){
        if(str.length==0)
            return 0;
        boolean[][] dp = new boolean[str.length][str.length];
        int maxLen = 1; // 记录最长回文串长度
        int start = 0;  // 记录最长回文串开始索引
        for(int i=0; i<str.length; i++)
            dp[i][i] = true;
        for(int i=0; i<str.length; i++){
            for(int j=0; j<=i; j++){
                if(i-j<2)
                    dp[j][i] = (str[j]==str[i]);
                else
                    dp[j][i] = (str[j]==str[i] && dp[j+1][i-1]);
                if(dp[j][i] && (i-j+1)>maxLen){
                    maxLen = (i-j+1);
                    start = j;
                }
            }
        }
        for(int i=0; i<str.length; i++){
            for(int j=0; j<str.length; j++)
                System.out.println(i + ", " + j + ": " + dp[i][j]);
        }
        System.out.println("maxLen: " + maxLen + ", start at: " + start);
        return maxLen;
    }

    public static void main(String[] args){
        LongestPalindrome lp = new LongestPalindrome();
        char[] str = "abbceecb".toCharArray();
        int result = lp.longestPalindrome(str);
        System.out.println(result);
    }
}
