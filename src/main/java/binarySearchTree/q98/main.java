package binarySearchTree.q98;

import BinaryTree.Tree;

public class main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        //tree.createTree(new Integer[]{2,1,3,null,null,null,null});
        //tree.createTree(new Integer[]{5,1,4,null,null,3,6,null,null,null,null});
        tree.createTree(new Integer[]{5,4,6,null,null,3,7,null,null,null,null});
        Solution solution = new Solution();
        boolean result = solution.isValidBST(tree.root);
        System.out.println(result);
    }
}
