package DP;

/**
 * Created by chenjianfeng on 2018/1/29.
 */

/**
 * 最长公共子序列
 */
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(char[] a, char[] b){
        if(a.length==0 || b.length==0)
            return 0;
        int[][] dp = new int[a.length][b.length];
        for(int i=0; i<b.length; i++) {
            if(a[0]==b[i] || (dp[0][i-1]==1 && i>0))
                dp[0][i] = 1;
        }
        for(int i=0; i<a.length; i++){
            if(b[0]==a[i] || (dp[i-1][0]==1 && i>0))
                dp[i][0] = 1;
        }
        for(int i=1; i<a.length; i++){
            for(int j=1; j<b.length; j++){
                if(a[i]==b[j])
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[a.length-1][b.length-1];
    }

    public int function(char[] a, char[] b){
        if(a.length==0 || b.length==0)
            return 0;
        int[][] dp = new int[a.length+1][b.length+1];
        for(int i=0; i<=b.length; i++)
            dp[0][i] = 0;
        for(int i=0; i<=a.length; i++)
            dp[i][0] = 0;
        for(int i=1; i<=a.length; i++){
            for(int j=1; j<=b.length; j++){
                if(a[i-1]==b[j-1])
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[a.length][b.length];
    }

    public static void main(String[] args){
        char[] a = "abcdefg".toCharArray();
        char[] b = "aacbcde".toCharArray();
        LongestCommonSubsequence LCS = new LongestCommonSubsequence();
        int result = LCS.longestCommonSubsequence(a,b);
        System.out.println(result);
        System.out.println(LCS.function(a,b));
    }
}
