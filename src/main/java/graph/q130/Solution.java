package graph.q130;

import java.util.Deque;
import java.util.LinkedList;

//0123456789  ()! &&
class Solution {
    public char[][] board;
    public boolean[][] visited;
    public int[][] result;
    public int[][] directions = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
    public void solve(char[][] board) {
        this.board = board;
        this.visited = new boolean[board.length][board[0].length];
        this.result = new int[board.length][board[0].length];
        Deque<int[]> queue = new LinkedList<>();
        for(int j=0;j<board[0].length;j++){
            if(!this.visited[0][j]&&this.board[0][j]=='O'){
                queue.addLast(new int[]{0,j});
            }
            if(!this.visited[board.length-1][j]&&this.board[board.length-1][j]=='O'){
                queue.addLast(new int[]{board.length-1,j});
            }
        }
        for(int i=1;i<board.length-1;i++){
            if(!this.visited[i][0]&&this.board[i][0]=='O'){
                queue.addLast(new int[]{i,0});
            }
            if(!this.visited[i][board[0].length-1]&&this.board[i][board[0].length-1]=='O'){
                queue.addLast(new int[]{i,board[0].length-1});
            }
        }

        while(!queue.isEmpty()){
            int[] cur = queue.removeFirst();
            this.visited[cur[0]][cur[1]] = true;
            this.result[cur[0]][cur[1]] = 1;
            for(int k=0;k< directions.length;k++){
                int new_i = cur[0]+directions[k][0];
                int new_j = cur[1]+directions[k][1];
                if(new_i>=0&&new_i<this.board.length&&new_j>=0
                        &&new_j<this.board[0].length
                        &&this.board[new_i][new_j]=='O'
                        &&!this.visited[new_i][new_j]){
                    queue.addLast(new int[]{new_i,new_j});
                }
            }
        }

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(this.result[i][j]!=1){
                    board[i][j] = 'X';
                }
            }
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board5 = new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        char[][] board = new char[][]{{'O','O','O','O','O','O','O','O','X','O','O','O','O','O','X','O','O','O','O','O'},
                {'O','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O','O','O'},
                {'X','O','O','X','O','X','O','O','O','O','X','O','O','X','O','O','O','O','O','O'},
                {'O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','X','X','O'},
                {'O','X','X','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O'},
                {'O','O','O','O','X','O','O','O','O','O','O','X','O','O','O','O','O','X','X','O'},
                {'O','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O','O','O'},
                {'O','O','O','O','O','O','O','O','O','O','O','O','O','X','O','O','O','O','O','O'},
                {'O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','X','O'},
                {'O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O','O','O','O','O'},
                {'O','O','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O','O'},
                {'O','O','O','O','X','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O'},
                {'O','O','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O','O'},
                {'X','O','O','O','O','O','O','O','O','X','X','O','O','O','O','O','O','O','O','O'},
                {'O','O','O','O','O','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O'},
                {'O','O','O','O','X','O','O','O','O','O','O','O','O','X','O','O','O','O','O','X'},
                {'O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','X','O','X','O','O'},
                {'O','X','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O'},
                {'O','O','O','O','O','O','O','O','X','X','O','O','O','X','O','O','X','O','O','X'},
                {'O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O'}};
        solution.solve(board);
        System.out.println(board);
    }

}