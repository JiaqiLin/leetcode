package dp.q279;

import java.lang.Math;

class Solution {
    public int numSquares(int n) {
        int [] dp = new int[n+1];
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            if((int)Math.sqrt(i)*(int)Math.sqrt(i)==i){
                dp[i] = 1;
            }else{
                int min = Integer.MAX_VALUE;
                for(int j=1;j<= i/2;j++){
                    if(dp[j]!=0&&dp[i-j]!=0){
                        if(dp[j]+dp[i-j]<min){
                            min = dp[j]+dp[i-j];
                        }
                    }}
                    if(min!=Integer.MAX_VALUE){
                        dp[i] = min;
                    }else{
                        dp[i] = 0;
                    }

            }

        }

        return dp[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numSquares(12));
    }
}
