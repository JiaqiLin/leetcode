package BinaryTree;

import java.util.Deque;
import java.util.LinkedList;

public class Travesal {

    public void noRecursionMidOrder(TreeNode root){
            Deque<TreeNode> stack = new LinkedList<TreeNode>();
            while (!stack.isEmpty() || root != null) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                // 访问当前节点
                System.out.println(root.val);
                root = root.right;
            }
    }
}
