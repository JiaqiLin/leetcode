package dp.q32;

class Solution {
    public int longestValidParentheses(String s) {
        int maxValidLength = 0;
        int n = s.length();
        int[] dp = new int[n];
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){
                dp[i] = 0;
            }else{
                if(i!=0){
                    if(s.charAt(i-1)=='('){
                        if(i>=2){
                            dp[i] = dp[i-2]+2;
                        }else{
                            dp[i] = 2;
                        }
                    }else{
                        int k = dp[i-1];
                        if(i-k-1>=0){
                            if(s.charAt(i-k-1)=='('){
                                if(i-k-2>=0){
                                    dp[i] = dp[i-k-2]+ k+2;
                                }else{
                                    dp[i] = k+2;
                                }
                            }

                        }

                    }
                }
            }

            maxValidLength = Math.max(maxValidLength,dp[i]);

        }
        return maxValidLength;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestValidParentheses(")()())"));
    }
}
