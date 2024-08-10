package backTrack.q77;

import java.util.List;

public class main {



    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 4,k = 2;
        List<List<Integer>> result = solution.combine(n,k);
        for (List<Integer> r:result) {
            System.out.println(r);
        }
    }
}
