package BinaryTree.q112;

import BinaryTree.TreeNode;

class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return hasPathSum1(root,0,targetSum);
    }


    public boolean hasPathSum1(TreeNode root, int sum, int targetSum){
        if(root==null){
            return false;
        }
        sum += root.val;
        if(sum==targetSum&&root.left==null&&root.right==null){
            return true;
        }
        return hasPathSum1(root.left,sum,targetSum) || hasPathSum1(root.right,sum,targetSum);
    }
}
