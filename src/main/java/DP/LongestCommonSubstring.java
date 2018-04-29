package DP;

/**
 * Created by chenjianfeng on 2018/1/29.
 */

public class LongestCommonSubstring {
    public int function(char[] a, char[] b){
        if(a.length==0 || b.length==0)
            return 0;
        int[][] dp = new int[a.length+1][b.length+1];
        int longest = 0;
        int startPosA = 0;
        int startPosB = 0;
        for(int i=0; i<=a.length; i++)
            dp[i][0] = 0;
        for(int j=0; j<=b.length; j++)
            dp[0][j] = 0;
        for(int i=1; i<=a.length; i++){
            for(int j=1; j<=b.length; j++){
                if(a[i-1]==b[j-1])
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = 0;
                if(dp[i][j]>longest) {
                    longest = dp[i][j];
                    startPosA = i - longest;
                    startPosB = j - longest;
                }
            }
        }
        System.out.println("maxLen: " + longest + ", startPosA: " + startPosA +
                ", startPosB: " + startPosB);
        return longest;
    }

    public static void main(String[] args){
        char[] a = "abcdefg".toCharArray();
        char[] b = "aacbcde".toCharArray();
        LongestCommonSubstring LCS = new LongestCommonSubstring();
        LCS.function(a, b);
    }
}
