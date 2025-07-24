package dp.q416;

class Solution {
    public boolean canPartition(int[] nums) {

        int sum = 0;

        for(int num:nums){
            sum+=num;
        }

        if(sum%2!=0){
            return false;
        }

        int target = sum/2;
        int n = nums.length;
        boolean[][] dp = new boolean[n][target+1];

        if(nums[n-1]<=target){
            dp[n-1][nums[n-1]] = true;
        }

        for(int i=n-2;i>=0;i--){
            for(int j=0;j<=target;j++){
                if(dp[i+1][j]) {
                    dp[i][j] = true;
                }else {
                    if(j>nums[i]){
                        dp[i][j] = dp[i+1][j - nums[i]];
                    }else{
                        dp[i][j] = false;
                    }

                }
            }
        }


        return dp[0][target];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1,5,11,5};
        System.out.println(solution.canPartition(nums));
    }
}
