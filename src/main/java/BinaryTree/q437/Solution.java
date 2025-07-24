package BinaryTree.q437;

import BinaryTree.Tree;
import BinaryTree.TreeNode;

class Solution {
    public int result=0;
    public int pathSum(TreeNode root, int targetSum) {
        dfs(root,targetSum);

        return result;
    }

    public void dfs(TreeNode root,int targetSum){
        if(root==null){
            return;
        }
        getPath(root,targetSum);

        dfs(root.left,targetSum);
        dfs(root.right,targetSum);

    }

    public void getPath(TreeNode root, int currentSum){
        if(root==null){
            return;
        }

        if(root.val==currentSum){
            result++;
        }
        getPath(root.left,currentSum-root.val);
        getPath(root.right,currentSum-root.val);



    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Tree tree = new Tree();
        tree.createTree2(new Integer[]{1,null,2,null,3,null,4,null,5});
        int result = solution.pathSum(tree.root,3);
        System.out.println(result);
    }
}
