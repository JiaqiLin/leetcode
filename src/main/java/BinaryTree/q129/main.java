package BinaryTree.q129;

import BinaryTree.Tree;

public class main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        //Integer[] treeList = new Integer[]{1,2,3,null,null,null,null};
        Integer[] treeList = new Integer[]{4,9,0,5,1,null,null,null,null,null,null};
        tree.createTree(treeList);
        Solution solution = new Solution();
        int sum = solution.sumNumbers(tree.root);
        System.out.println(sum);
    }
}
