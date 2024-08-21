package q17;

import q17.q17;

import java.util.List;

public class main {
    public static void main(String[] args) {
//        String[] tokens = new String[]{"2","1","+","3","*"};
//        Solution solution = new Solution();
//        System.out.println(solution.evalRPN(tokens));

        String digits = "23";
        q17 solution = new q17();
        List<String> result = solution.letterCombinations(digits);
        for (String i:result) {
            System.out.println(i);
        }
        System.out.println(result);
    }
}