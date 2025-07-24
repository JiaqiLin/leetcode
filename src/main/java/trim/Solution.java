package trim;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


//0123456789  ()
class Solution {
    public char[][] board;
    public boolean[][] visit;
    int[][] directions = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
    List<String> result = new ArrayList<>();
    Trim trim;
    class Trim{
        private int id = 1;
        private int[][] trim;
        public int[] cnt;
        public Trim(int wordsNum){
            this.trim = new int[wordsNum*11][26];
            this.cnt = new int[wordsNum*11];
        }
        public void insert(String s){
            int preId = 0;
            for(int i=0;i<s.length();i++){
                int x = s.charAt(i)-97;
                if(this.trim[preId][x]==0){
                    this.trim[preId][x] = id;
                    id++;
                }
                preId = this.trim[preId][x];
            }
            cnt[preId] += 1;
        }

        public boolean find(String s){
            int preId = 0;
            for(int i=0;i<s.length();i++){
                int x = s.charAt(i)-97;
                if(this.trim[preId][x]!=0){
                    preId = this.trim[preId][x];
                }else{
                    return false;
                }
            }
            return cnt[preId]>0;
        }
        public int find(int last, char cur){
            return this.trim[last][cur-97];
        }
        public boolean ifEnd(int index){
            return this.cnt[index]>0;
        }
    }
    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        this.visit = new boolean[board.length][board[0].length];
        this.trim = new Trim(words.length);
        for(String s: words){
            this.trim.insert(s);
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                dfs(i,j,0,new ArrayList<>());
            }
        }
        return result;

    }

    public void dfs(int i, int j, int last, ArrayList<Character> curResult){
        this.visit[i][j] = true;
        curResult.add(this.board[i][j]);
        int new_last = this.trim.find(last,this.board[i][j]);
        if(new_last!=0){
            if(this.trim.ifEnd(new_last)){
                StringBuilder sb = new StringBuilder();
                for (Character ch : curResult) {
                    sb.append(ch);
                }
                this.result.add(sb.toString());
                this.trim.cnt[new_last] = 0;
            }
            for(int[] direction: this.directions){
                if(i+direction[0]>=0&&i+direction[0]<this.board.length&&j+direction[1]>=0&&j+direction[1]<this.board[0].length
                        &&!this.visit[i+direction[0]][j+direction[1]]){
                    dfs(i+direction[0],j+direction[1],new_last,curResult);
                }
            }
        }
        this.visit[i][j] = false;
        curResult.remove(curResult.size()-1);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][]board = new char[][]{{'o','a','a','n'}, {'e','t','a','e'}, {'i','h','k','r'},{'i','f','l','v'}};
        String[] words = new String[]{"oath","pea","eat","rain"};
        solution.findWords(board,words);
    }
}
