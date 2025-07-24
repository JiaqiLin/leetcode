package greedy.q763;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        int i=0;
        int n = s.length();
        while(i<n){
            int end=i;

            for(int j=i;j<=end;j++){
                int newEnd = getFirstLetter(s, end+1, s.charAt(j));
                if(newEnd!=-1){
                    end = newEnd;
                }
            }
            result.add(end-i+1);

            i = end+1;
        }



        return result;
    }


    public int getFirstLetter(String s,int begin,char c){
        for(int i=begin;i<s.length();i++){
            if(s.charAt(i)==c){
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.partitionLabels("eccbbbbdec"));
    }



}