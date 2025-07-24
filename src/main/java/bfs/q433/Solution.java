package bfs.q433;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public boolean ifDiffOne(String A, String B){
        int diff = 0;
        for(int i = 0;i<A.length();i++){
            if(A.charAt(i)!=B.charAt(i)) diff++;
        }
        return diff==1;
    }

    public boolean ifNotInArray(String A, List<String> currentStrings){
        for(String str:currentStrings){
            if(A.equals(str)) return false;
        }
        return true;
    }


    public int minMutation(String startGene, String endGene, String[] bank) {

        Deque<String> sDeque = new LinkedList<String>();
        List<String> tempDeque = new ArrayList<String>();
        List<String> currentStrings = new ArrayList<>();
        sDeque.add(startGene);
        tempDeque.add(startGene);

        int result = Integer.MAX_VALUE;

        int level = 0;



        while(!sDeque.isEmpty()){

            int size = sDeque.size();
            while(size--!=0){
                String currentGene = sDeque.removeFirst();

                currentStrings.add(currentGene);
                if(currentGene.equals(endGene)){
                    return level;
                }
                int count = 0;
                for(int i = 0;i<bank.length;i++){
                    if(ifDiffOne(currentGene,bank[i])&&ifNotInArray(bank[i], tempDeque)){
                        sDeque.add(bank[i]);
                        tempDeque.add(currentGene);
                        count+=1;
                    }
                }
                if(count == 0){
                    currentStrings.remove(currentStrings.size()-1);
                }
            }

            level++;


        }
        return -1;
    }
}
