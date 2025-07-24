package stack.q394;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public String decodeString(String s) {


        Deque<Character> deque = new LinkedList<>();

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==']'){
                ArrayList<Character> charList = new ArrayList<>();
                while(deque.getLast()!='['){
                    charList.add(deque.removeLast());
                }
                deque.removeLast();
                int times = 0;
                int bit = 0;
                while(!deque.isEmpty()&&deque.getLast()>='0'&&deque.getLast()<='9'){
                    times += Integer.parseInt(String.valueOf(deque.removeLast()))*Math.pow(10,bit);
                    bit+=1;
                }

                for(int k=0;k<times;k++){
                    for(int j=charList.size()-1;j>=0;j--){
                        deque.add(charList.get(j));
                    }
                }

            }else{
                deque.addLast(s.charAt(i));

            }

        }

        StringBuffer sb = new StringBuffer();
        while(!deque.isEmpty()){
            sb.append(deque.removeFirst());
        }

        return sb.toString();



    }

    public static void main(String[] args) {
        Solution solution = new Solution();
       String result =  solution.decodeString("3[a2[c]]");
        System.out.println(result);
    }
}
