package array.q5;

class Solution {
    public int candy(int[] ratings) {
        int result = 0;
        int n =  ratings.length;
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        for(int i=1;i<n;i++){
            arr1[i] = ratings[i]<=ratings[i-1]?0:1;
        }
        for(int i=0;i<n-1;i++){
            arr2[i] = ratings[i]<=ratings[i+1]?0:1;
        }


        for(int i=1;i<n;i++){
            if(arr1[i]==1){
                arr1[i] = arr1[i-1] + 1;
            }
        }
        for(int i=n-1;i>0;i--){
            if(arr2[i]==1){
                arr2[i] = arr2[i+1] + 1;
            }
        }
        for(int i=0;i<n;i++){
            result += (Math.max(arr1[i], arr2[i]) + 1);
        }
        return result;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ratings = new int[]{1,2,2};
        System.out.println(solution.candy(ratings));
    }
}