package graph.q3341;

import java.util.Arrays;

class Solution {

    private int[][] moveTime;
    private boolean[][] visited;
    private int[][] dp;
    private int minTime = Integer.MAX_VALUE;
    private int m;
    private int n;
    private int[][] directions = {{-1,0},{0,1},{1,0},{0,-1}};
    public int minTimeToReach(int[][] moveTime) {
        this.n = moveTime.length;
        this.m = moveTime[0].length;
        this.moveTime = moveTime;
        this.visited = new boolean[n][m];

        this.dp = new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(this.dp[i],Integer.MAX_VALUE);
        }
        dfs(0, 0, 0);
        return minTime;
    }

    public void dfs(int i, int j, int time){
        if(i==n-1&&j==m-1){
            if(time>=moveTime[i][j]){
                minTime = Math.min(time, minTime);
            }
            return;
        }
        this.visited[i][j] = true;

        for(int k=0;k<directions.length;k++){
            int new_i = i+directions[k][0];
            int new_j = j+directions[k][1];
            if(new_i>=0&&new_i<n&&new_j>=0&&new_j<m&&!visited[new_i][new_j]){
                int newTime = Math.max(time+1,moveTime[new_i][new_j]+1);
                if(newTime<this.dp[new_i][new_j]){
                    dfs(new_i, new_j, newTime);
                }
            }
        }
        this.visited[i][j] = false;
    }

    public static void main(String[] args){
        int[][] moveTime = new int[][]{{0,4},{4,4}};
        Solution solution = new Solution();
        System.out.println(solution.minTimeToReach(moveTime));
    }

}


//import java.util.Arrays;
//import java.util.Comparator;
//import java.util.PriorityQueue;
//
//class Solution {
//
//    private int[][] dp;
//    private int m;
//    private int n;
//    private int[][] directions = {{-1,0},{0,1},{1,0},{0,-1}};
//    public int minTimeToReach(int[][] moveTime) {
//        this.n = moveTime.length;
//        this.m = moveTime[0].length;
//        this.dp = new int[n][m];
//        for(int i=0;i<n;i++){
//            Arrays.fill(this.dp[i],Integer.MAX_VALUE);
//        }
//
//
//        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[2]-o2[2];
//            }
//        });
//        pq.add(new int[]{0,0,0});
//        this.dp[0][0] = 0;
//        while(!pq.isEmpty()){
//            int[] cur = pq.poll();
//            for(int k=0;k<directions.length;k++){
//            int new_i = cur[0]+directions[k][0];
//            int new_j = cur[1]+directions[k][1];
//            if(new_i>=0&&new_i<n&&new_j>=0&&new_j<m){
//                int newTime = Math.max(cur[2]+1,moveTime[new_i][new_j]+1);
//                if(this.dp[new_i][new_j]>newTime){
//                    this.dp[new_i][new_j] = newTime;
//                    pq.add(new int[]{new_i,new_j,newTime});
//                }
//            }
//        }
//        }
//        return this.dp[n-1][m-1] ;
//    }
//
//    public static void main(String[] args){
//        int[][] moveTime = new int[][]{{0,4},{4,4}};
//        Solution solution = new Solution();
//        System.out.println(solution.minTimeToReach(moveTime));
//    }
//
//}
