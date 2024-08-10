package BinaryTree.q112;

import BinaryTree.Tree;

public class main {



    public static void main(String[] args) {
//        Integer[] root = new Integer[]{5,4,8,11,null,13,4,7,2,null,null,null,1};
//        int targetSum = 22;

        Integer[] root = new Integer[]{1};
        int targetSum = 1;
        Tree tree = new Tree();
        tree.createTree(root);
        Solution solution = new Solution();
        Boolean result = solution.hasPathSum(tree.root,targetSum);
        System.out.println(result);
    }
}
