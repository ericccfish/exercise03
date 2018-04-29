package DP;

/**
 * Created by chenjianfeng on 2018/1/29.
 */

public class ZeroOnePackage {
    public int maxValue(int[] cost, int[] w, int V){
        if(cost.length==0 || cost.length!=w.length)
            return 0;
        int[][] dp = new int[cost.length+1][V+1];
        for(int i=0; i<=V; i++)
            dp[0][i] = 0;
        for(int i=0; i<=cost.length; i++)
            dp[i][0] = 0;
        for(int i=1; i<=cost.length; i++){
            for(int v=V; v>=1; v--){
                if(v>=cost[i-1])
                    dp[i][v] = Math.max(dp[i-1][v-cost[i-1]]+w[i-1], dp[i-1][v]);
                else
                    dp[i][v] = dp[i-1][v];
                System.out.println(i + "," + v + " >>> " + dp[i][v]);
            }
        }
        return dp[cost.length][V];
    }

    public static void main(String[] args){
        int[] cost = new int[]{1,2,3,4,8};
        int[] w = new int[]{4,6,8,10,30};
        ZeroOnePackage zop = new ZeroOnePackage();
        System.out.println(zop.maxValue(cost, w, 10));
    }
}
