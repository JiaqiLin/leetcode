package bfs.q433;

public class main {



    public static void main(String[] args) {
        String startGene = "AAAACCCC";
        String endGene = "CCCCCCCC";
        String[]bank =    {"AAAACCCA","AAACCCCA","AACCCCCA","AACCCCCC","ACCCCCCC","CCCCCCCC","AAACCCCC","AACCCCCC"};

        Solution solution = new Solution();
        int result = solution.minMutation(startGene,endGene,bank);
        System.out.println(result);
    }


}
