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
                if(dp[k]>=max && arr[i]>arr[k])
                    max = dp[k];
            }
            dp[i] = max + 1;
        }
        return dp[arr.length - 1];
    }
    public static void main(String[] args) throws Exception{
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        int[] arr = new int[]{1,7,8,2,3,5,4,10};
        System.out.println(lis.LIS(arr));
    }
}
