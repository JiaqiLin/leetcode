package backTrack.q77;

import java.util.*;

public class Solution {
    public List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> numList = new ArrayList<Integer>();
        backtrack(numList,0,k,n);
        return result;
    }

    public void backtrack(List<Integer> numList,int index,int k,int n){
        if(numList.size()==k){
            result.add(new ArrayList<>(numList));
            return;
        }

        for(int i = index+1;i<n+1;i++){
            numList.add(i);
            backtrack(numList,i,k,n);
            numList.remove(numList.size()-1);
        }

    }
}
