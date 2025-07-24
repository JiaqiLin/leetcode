package multiDimensionDP.q221;

class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int maxSquare = 0;
        int dp[][] = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i>0){
                    dp[i][j] += dp[i-1][j];
                }
                if(j>0){
                    dp[i][j] += dp[i][j-1];
                }
                if(i>0&&j>0){
                    dp[i][j] -= dp[i-1][j-1];
                }
                dp[i][j] += matrix[i][j]-48;
            }
        }

        for(int s=1;s<Math.min(m,n);s++){
            for(int i=0;i<m-s;i++){
                for(int j=0;j<n-s;j++){
                    int result = dp[i+s][j+s];
                    if(i>0){
                        result -= dp[i-1][j+s];
                    }
                    if(j>0){
                        result -= dp[i+s][j-1];
                    }
                    if(i>0&&j>0){
                        result += dp[i-1][j-1];
                    }
                    if(result==(s+1)*(s+1)){
                        maxSquare = Math.max(maxSquare, result);
                    }

                }
            }
        }

        return maxSquare;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] matrix = new char[][]{{'1','1','1','1','1'},{'1','1','1','1','1'},{'0','0','0','0','0'},{'1','1','1','1','1'},{'1','1','1','1','1'}};
        //char[][] matrix = new char[][][["1","1","1","1","1"],["1","1","1","1","1"],["0","0","0","0","0"],["1","1","1","1","1"],["1","1","1","1","1"]];
        int result = solution.maximalSquare(matrix);
        System.out.println(result);
    }
}
