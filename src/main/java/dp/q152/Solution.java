package dp.q152;

import java.util.Arrays;

class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[][] maxPositiveMinNegative = new int[n][2];
        int result = Arrays.stream(nums).min().getAsInt();
        if(n>=1){
            maxPositiveMinNegative[0][0] = nums[0];
            maxPositiveMinNegative[0][1] = nums[0];
        }
        for (int i = 1; i < n; i++) {
            if (nums[i] > 0) {
                if (maxPositiveMinNegative[i - 1][0] > 0) {
                    maxPositiveMinNegative[i][0] = nums[i] * maxPositiveMinNegative[i - 1][0];
                } else {
                    maxPositiveMinNegative[i][0] = nums[i];
                }

                if (maxPositiveMinNegative[i - 1][1] < 0) {
                    maxPositiveMinNegative[i][1] = nums[i] * maxPositiveMinNegative[i - 1][1];
                } else {
                    maxPositiveMinNegative[i][1] = nums[i];
                }
                if(maxPositiveMinNegative[i][0]==0){
                    maxPositiveMinNegative[i][0] = nums[i];
                }
                if(maxPositiveMinNegative[i][1]==0){
                    maxPositiveMinNegative[i][1] = nums[i];
                }

            } else {
                if (maxPositiveMinNegative[i - 1][0] > 0) {
                    maxPositiveMinNegative[i][1] = nums[i] * maxPositiveMinNegative[i - 1][0];
                }

                if (maxPositiveMinNegative[i - 1][1] < 0) {
                    maxPositiveMinNegative[i][0] = nums[i] * maxPositiveMinNegative[i - 1][1];
                }
                if(maxPositiveMinNegative[i][0]==0){
                    maxPositiveMinNegative[i][0] = nums[i];
                }
                if(maxPositiveMinNegative[i][1]==0){
                    maxPositiveMinNegative[i][1] = nums[i];
                }

            }


        }

        for(int i=0;i<n;i++){
            if(result<maxPositiveMinNegative[i][0]){
                result = maxPositiveMinNegative[i][0];
            }
        }
        return result;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{-2};
        System.out.println(solution.maxProduct(nums));
    }
}
