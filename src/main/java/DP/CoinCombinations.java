package DP;

/**
 * Created by chenjianfeng on 2018/1/29.
 */

/**
 * 假设有无限枚面值为1，2，5的硬币，凑够10元总共有多少种组合？
 */

public class CoinCombinations {
    public int function(int[] coin, int sum){
        if(coin.length==0)
            return 0;
        int[][] dp = new int[coin.length+1][sum+1];
        for(int i=0; i<=coin.length; i++)
            dp[i][0] = 1;
        for(int i=0; i<=sum; i++)
            dp[0][sum] = 0;
        for(int i=1; i<=coin.length; i++){
            for(int j=1; j<=sum; j++) {
                for (int k=0; k<=j/coin[i-1]; k++) {
                    dp[i][j] += dp[i-1][j-k*coin[i-1]];
                }
            }
        }
        return dp[coin.length][sum];
    }

    public static void main(String[] args){
        int[] coin = new int[]{1,2,5};
        CoinCombinations cc = new CoinCombinations();
        System.out.println(cc.function(coin, 10));
    }
}
