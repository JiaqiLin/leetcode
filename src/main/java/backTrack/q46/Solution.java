package backTrack.q46;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums,0);
        return result;
    }

    public void backtrack(int[] numList,int index){
        if(index==numList.length){
            List<Integer> currentResult = new ArrayList<>();
            for(int i=0;i<numList.length;i++){
                currentResult.add(numList[i]);
            }
            result.add(currentResult);
            return;
        }

        for(int i = index;i<numList.length;i++){
            int temp = numList[index];
            numList[index] = numList[i];
            numList[i] = temp;
            backtrack(numList,index+1);
            int temp2 = numList[index];
            numList[index] = numList[i];
            numList[i] = temp2;
        }

    }

}
