package DP;

/**
 * Created by chenjianfeng on 2017/12/6.
 */
public class LongestIncreasingSubsequence {
    public int LIS(int[] arr){
        if(arr.length==0)
            return 0;
        int[] dp = new int[arr.length];
        dp[0] = 1;
        for(int i=1; i<arr.length; i++){
            int max = 0;
            for(int k=0; k<i; k++){
                if(dp[k]>=max && arr[i]>arr[k])        // 此处不正确, 2018.01.29
                    max = dp[k];
            }
            dp[i] = max + 1;
        }
        return dp[arr.length - 1];
    }

    public int function(int[] arr){
        if(arr.length==0)
            return 0;
        int[] dp = new int[arr.length];
        int currMax = arr[0];
        dp[0] = 1;
        for(int i=1; i<arr.length; i++){
            if(arr[i]>=currMax){
                dp[i] = dp[i-1] + 1;
                currMax = arr[i];
            }
            else{
                dp[i] = dp[i-1];
                int cnt = 0;
                for(int j=0; j<=i; j++){
                    if(arr[j]<=arr[i])
                        cnt++;
                }
                if(cnt>=dp[i])
                    currMax = arr[i];
            }
        }
        return dp[arr.length-1];
    }
    public static void main(String[] args) throws Exception{
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        int[] arr = new int[]{1,7,8,2,3,5,4,10};
        System.out.println(lis.LIS(arr));
        System.out.println(lis.function(arr));

        int[] arr2 = new int[]{1,7,8,2};
        System.out.println(lis.LIS(arr2));
        System.out.println(lis.function(arr2));
    }
}
