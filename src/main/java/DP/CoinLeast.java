package DP;

/**
 * Created by chenjianfeng on 2018/1/29.
 */

/**
 * 假设我们有面值为1元、3元和5元的硬币若干枚，最少用多少枚硬币可以凑够11元？
 */

public class CoinLeast {
    public int function(int[] coin, int sum){
        if(coin.length==0)
            return 0;
        int[] dp = new int[sum+1];
        dp[0] = 0;
        for(int i=1; i<=sum; i++){
            int min = Integer.MAX_VALUE;
            for(int j=0; j<coin.length; j++){
                if(i>=coin[j] && dp[i-coin[j]]<min)
                    min = dp[i-coin[j]];
            }
            dp[i] = min + 1;
        }
        return dp[sum];
    }

    public static void main(String[] args){
        CoinLeast cl = new CoinLeast();
        int[] coin = new int[]{1,3,5};
        System.out.println(cl.function(coin,11));
    }
}
