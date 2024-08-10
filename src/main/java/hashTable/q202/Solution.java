package hashTable.q202;

import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public boolean isHappy(int n) {
        int temp = n;
        int happy = 0;
        HashSet<Integer> set = new HashSet<Integer>();
        while(happy != 1){
            happy = 0;
            while(temp!=0){
                happy += Math.pow(temp%10,2) ;
                temp /= 10;
            }
            if(set.contains(happy)){
                return false;
            }
            set.add(happy);
            temp = happy;
        }
        return true;
    }
}
