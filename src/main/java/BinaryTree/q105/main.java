package BinaryTree.q105;


import BinaryTree.TreeNode;

public class main {

    public static void main(String[] args) {
//        int[] preorder = new int[]{3,9,20,15,7}, inorder = new int[]{9,3,15,20,7};
        int[] preorder = new int[]{-1}, inorder = new int[]{-1};
        Solution solution = new Solution();
        TreeNode result = solution.buildTree(preorder,inorder);
        System.out.println(result);
    }


}
