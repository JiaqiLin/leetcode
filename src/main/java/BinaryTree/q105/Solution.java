package BinaryTree.q105;

import BinaryTree.TreeNode;

import java.util.Arrays;

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder){
        if(preorder.length==0){
            return null;
        }

        TreeNode node = new TreeNode(preorder[0]);
        //从中序中找到左子树和右子树
        int i = 0;
        while(inorder[i]!=preorder[0]) i++;

        int leftLength = i,rightLength = preorder.length - 1 - i;

        node.left = buildTree(Arrays.copyOfRange(preorder, 1, 1+leftLength),Arrays.copyOfRange(inorder, 0, leftLength));
        node.right = buildTree(Arrays.copyOfRange(preorder, 1+leftLength, 1+leftLength+rightLength),Arrays.copyOfRange(inorder, leftLength+1, leftLength+1+rightLength));

        return node;

    }

//    public TreeNode backtrack(int[] preorder, int[] inorder,int preorderStart, int preorderEnd,int inorderStart,int inorderEnd,TreeNode ){
//
//    }

}
