package BinaryTree.q101;

import BinaryTree.TreeNode;

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetricBetweenTwoChildTree(root.left,root.right);
    }

    public boolean isSymmetricBetweenTwoChildTree(TreeNode left, TreeNode right) {
        if(left == null&&right==null){
            return true;
        } else if(left!=null&&right==null){
            return false;
        } else if (left==null&&right!=null) {
            return false;
        }else{
            if(left.val==right.val) {
                return isSymmetricBetweenTwoChildTree(left.left, right.right) && isSymmetricBetweenTwoChildTree(left.right, right.left);
            }else {
                return false;
            }

        }
    }
}
