package multiDimensionDP.q62;
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] paths = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0){
                    paths[i][j] = 1;
                } else if (j==0) {
                    paths[i][j] = 1;
                }else{
                    paths[i][j] = paths[i-1][j] + paths[i][j-1];
                }
            }
        }
        return paths[m-1][n-1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.uniquePaths(3,2));
    }


}
