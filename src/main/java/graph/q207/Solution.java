package graph.q207;

class Solution {
    private int[] visited;
    private int[][] graph;
    private boolean ifLoop = false;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited =  new int[numCourses];
        graph = new int[numCourses][numCourses];
        for(int i=0;i<prerequisites.length;i++){
            graph[prerequisites[i][0]][prerequisites[i][1]] = 1;
        }
        for(int i=0;i<numCourses;i++){
            dfs(i, numCourses);
        }


        return !ifLoop;




    }

    public void dfs(int i,int numCourses){
        visited[i] = 1;
        for(int j =0;j<numCourses;j++){
            if(graph[i][j]==1){
                if(visited[j]==1){
                    ifLoop = true;
                    break;
                }else if(visited[j]==-1){
                    continue;
                }else{
                    dfs(j, numCourses);
                }
            }
        }
        visited[i] = -1;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int numCourses = 20;
        int [][] prerequisites = new int[][]{{0,10},{3,18},{5,5},{6,11},{11,14},{13,1},{15,1},{17,4}};
        boolean result = solution.canFinish(numCourses,prerequisites);
        System.out.println(result);
    }
}
