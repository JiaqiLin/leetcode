package binarySearchTree.q98;

import BinaryTree.TreeNode;

import java.util.ArrayList;

class Solution {
//    public boolean isValidBST(TreeNode root) {
//        if(root==null){
//            return true;
//        }
//        if(root.left!=null){
//            if(root.val<=root.left.val){
//                return false;
//            }
//        }
//        if(root.right!=null){
//            if(root.val>=root.right.val){
//                return false;
//            }
//        }
//        return isValidBST(root.left)&&isValidBST(root.right);
//    }

    ArrayList<Integer> treeList = new ArrayList<>();

    public boolean isValidBST(TreeNode root) {
        midOrder(root);
        for(int i=0;i<treeList.size()-1;i++){
            if(treeList.get(i)>=treeList.get(i+1)){
                return false;
            }
        }
        return true;
    }


//    public boolean backTrack(TreeNode root,int parent,boolean ifLeft) {
//        if(root==null){
//            return true;
//        }
//
//        if(ifLeft){
//            if(root.val>=parent){
//                return false;
//            }
//        }else {
//            if(root.val<=parent){
//                return false;
//            }
//        }
//        if(root.left!=null){
//            if(root.val<=root.left.val){
//                return false;
//            }
//        }
//        if(root.right!=null){
//            if(root.val>=root.right.val){
//                return false;
//            }
//        }
//        return backTrack(root.left, root.val, true)&&backTrack(root.right,root.val,false);
//    }


    public void midOrder(TreeNode root){
        if(root==null){
            return;
        }
        midOrder(root.left);
        treeList.add(root.val);
        midOrder(root.right);
    }
}


//class Solution {
//    public boolean isValidBST(TreeNode root) {
//        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
//    }
//
//    public boolean isValidBST(TreeNode node, long lower, long upper) {
//        if (node == null) {
//            return true;
//        }
//        if (node.val <= lower || node.val >= upper) {
//            return false;
//        }
//        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
//    }
//}
//
//作者：力扣官方题解
//链接：https://leetcode.cn/problems/validate-binary-search-tree/solutions/230256/yan-zheng-er-cha-sou-suo-shu-by-leetcode-solution/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。