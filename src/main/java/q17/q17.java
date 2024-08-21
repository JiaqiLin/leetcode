package q17;

import java.util.*;

class q17 {
    public List<String> letterCombinations(String digits) {
        if(digits.equals("")){
            return new ArrayList<>();
        }
        char[] result = digits.toCharArray();;
        Map<Character,String> phoneMap = new HashMap<Character,String>(){
            {
                put('2',"abc");
                put('3',"def");
                put('4',"ghi");
                put('5',"jkl");
                put('6',"mno");
                put('7',"pqrs");
                put('8',"tuv");
                put('9',"wxyz");

            }
        };
        List<String> all_result = new ArrayList<>();
        backtrack(digits,0,result,phoneMap,all_result);
        return all_result;
    }
    public void backtrack(String digits, Integer index, char[] result,Map<Character,String> phoneMap, List<String> all_result){
        if(index == digits.length()){
            all_result.add(String.valueOf(result));
            return;
        }
        String phoneCharacters = phoneMap.get(digits.charAt(index));
        for(int i = 0;i<phoneCharacters.length();i++){
            result[index] = phoneCharacters.charAt(i);
            backtrack(digits,index+1,result,phoneMap,all_result);
        }
    }
}