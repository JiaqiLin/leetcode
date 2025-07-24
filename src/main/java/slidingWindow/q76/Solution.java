package slidingWindow.q76;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> counts = new HashMap<>();
        for(int i=0;i<t.length();i++){
            counts.put(t.charAt(i),counts.getOrDefault(t.charAt(i),0)+1);
        }

        // 重新构造一个hashtable，用于后面判断是否改变
        Map<Character,Integer> finalCounts = new HashMap<>();
        for(int i=0;i<t.length();i++){
            finalCounts.put(t.charAt(i),finalCounts.getOrDefault(t.charAt(i),0)+1);
        }

        int p = 0,q=0;
        //找第一个满足的最短串
        while(p<s.length()&&counts.get(s.charAt(p))==null){
            p++;
        }
        //全部不满足
        if(p==s.length()){
            return "";
        }
        //记录当前状态的hashtable
        Map<Character,Integer> currentCounts = new HashMap<>();

        q = p-1;
        while(!counts.isEmpty()){
            q++;
            if(q>=s.length()){
                break;
            }
            if(counts.get(s.charAt(q))!=null){
                if(counts.get(s.charAt(q))>1){
                    counts.put(s.charAt(q),counts.get(s.charAt(q))-1);
                }else if(counts.get(s.charAt(q))==1){
                    counts.remove(s.charAt(q));
                }
            }
            if(finalCounts.get(s.charAt(q))!=null){
                currentCounts.put(s.charAt(q),currentCounts.getOrDefault(s.charAt(q),0)+1);
            }


        }
        if(counts.size()!=0){
            return "";
        }

        int minLength = q-p+1;
        int minStart = p;
        int minEnd = q;

        boolean endloop = false;
        while(p<=q&&q<s.length()){
            if(finalCounts.get(s.charAt(p))!=null&& Objects.equals(finalCounts.get(s.charAt(p)), currentCounts.get(s.charAt(p)))){
                currentCounts.put(s.charAt(p),currentCounts.get(s.charAt(p))-1);
                while(q<s.length()&& !Objects.equals(finalCounts.get(s.charAt(p)), currentCounts.get(s.charAt(p)))){
                    q++;
                    if(q==s.length()){
                        endloop = true;
                        break;
                    }
                    if(finalCounts.get(s.charAt(q))!=null){
                        currentCounts.put(s.charAt(q),currentCounts.getOrDefault(s.charAt(q),0)+1);
                    }
                }
                if(endloop){
                    break;
                }
            }else{

                if(finalCounts.get(s.charAt(p))!=null){
                    currentCounts.put(s.charAt(p),currentCounts.get(s.charAt(p))-1);
                }
//                p++;
            }
            p++;

            if(q-p+1<minLength){
                minLength = q-p+1;
                minStart = p;
                minEnd = q;
            }
        }
        return s.substring(minStart,minEnd+1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //String s = "ADOBECODEBANC", t = "ABC";
        String s = "a", t="b";
        //String s = "aa", t = "a";
        System.out.println(solution.minWindow(s,t));
    }
}
