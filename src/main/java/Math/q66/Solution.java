package Math.q66;

import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] plusOne(int[] digits) {
        ArrayList<Integer> result = new ArrayList<>();
        int carry = 1;
        for (int i=digits.length-1;i>=0;i--){
            int current_result = digits[i] + carry;
            carry = current_result/10;
            result.add(current_result%10);
        }
        if (carry == 1){
            result.add(carry);
        }
        Collections.reverse(result);
        int[] finalResult = new int[result.size()];
        for(int i=0;i<result.size();i++){
            finalResult[i] = result.get(i);
        }
        return finalResult;
    }
}