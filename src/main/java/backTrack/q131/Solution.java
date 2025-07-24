package backTrack.q131;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<String>> results;
    public List<List<String>> partition(String s) {
        results = new ArrayList<>();
        int[] split = new int[s.length()-1];
        backTrack(0, s.length()-1, split, s);
        return results;
    }



    public void backTrack(int k,int n,int [] split,String s){
        //最后一层出结果
        if(k==n){
            int currentBegin = 0;
            List<String> result = new ArrayList<>();
            for(int i=0;i<split.length;i++){
                if(split[i]==1){
                    result.add(s.substring(currentBegin, i+1));
                    currentBegin = i+1;
                }
            }
            if(ifHuiWen(s.substring(currentBegin,s.length()))){
                result.add(s.substring(currentBegin,s.length()));
                results.add(result);
            }
            return;
        }


        //判断该切分是否为回文
        int begin = getLastSplitLocation(split, k);
        if(ifHuiWen(s.substring(begin+1,k+1))){
            split[k] = 1;
            backTrack(k+1,n,split,s);
        }
        split[k] = 0;
        backTrack(k+1,n,split,s);




    }
    public int getLastSplitLocation(int[] split,int k){
        for(int i=k-1;i>=0;i--){
            if(split[i]==1){
                return i;
            }
        }
        return -1;
    }

    public boolean ifHuiWen(String s){
        String reversedS = new StringBuilder(s).reverse().toString();
        if(s.equals(reversedS)){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.partition("a"));


    }
}
