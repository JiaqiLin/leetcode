package BinaryTree;

import java.util.Deque;
import java.util.LinkedList;

public class Tree {

    public TreeNode root;
    public void createTree(Integer[] treeNodes){
        Deque<TreeNode> treeDeque = new LinkedList<TreeNode>();
        if(treeNodes.length>0){
            root = new TreeNode(treeNodes[0]);
            treeDeque.add(root);

        }
        int index = 1;
        while(!treeDeque.isEmpty()&&index<treeNodes.length){
            //弹出父节点
            TreeNode parent = treeDeque.removeFirst();
            if(parent!=null){
                Integer left = index<treeNodes.length?treeNodes[index]:null;
                Integer right = index+1<treeNodes.length?treeNodes[index+1]:null;
                createTreeChild(parent,left,right);
                treeDeque.addLast(parent.left);
                treeDeque.addLast(parent.right);
            }

        }
    }

    public void createTreeChild(TreeNode node,Integer left,Integer right){
        if(left==null){
            node.left = null;
        }else{
            node.left = new TreeNode(left);
        }
        if(right==null){
            node.right = null;
        }else{
            node.right = new TreeNode(right);
        }

    }
}
