package Math.q31;

class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n-1;
        int j =n-1;
        for(;i>0;i--){
            if(nums[i-1]<nums[i]){
                break;
            }
        }
        if(i!=0){
            for(;j>=i;j--){
                if(nums[j]>nums[i-1]){
                    break;
                }
            }
            //交换i-1和j
            int temp1 = nums[i-1];
            nums[i-1] = nums[j];
            nums[j] = temp1;
        }

        int k = 0;
        while(k<=(n-1-i)/2){
            int temp = nums[i+k];
            nums[i+k] = nums[n-1-k];
            nums[n-1-k] = temp;
            k++;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{2,3,1};
        solution.nextPermutation(nums);
        for(int num:nums){
            System.out.println(num);
        }
    }
}
