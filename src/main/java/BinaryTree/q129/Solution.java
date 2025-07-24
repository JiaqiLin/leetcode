package BinaryTree.q129;

import BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static java.lang.Math.pow;

class Solution {
    public int sumNumbers(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<Integer> results = new ArrayList<>();
        dfs(root, res, results);
        int sum = 0;
        for(Integer i: results) {
            sum+=i;
        }
        return sum;
    }


    public void dfs(TreeNode root, ArrayList<Integer> res,ArrayList<Integer> results) {
        res.add(root.val);
        if(root.left==null&&root.right==null){
            int num = 0;
            for(int i = res.size()-1,j=0;i>=0;i--,j++){
                num+=res.get(i)*pow(10,j);
            }
            results.add(num);
        }
        if(root.left!=null){
            dfs(root.left,res,results);
        }
        if(root.right!=null){
            dfs(root.right,res,results);
        }

        res.remove(res.size()-1);


    }
}


//class Solution {
//    public int sumNumbers(TreeNode root) {
//        return dfs(root, 0);
//    }
//
//    public int dfs(TreeNode root, int prevSum) {
//        if (root == null) {
//            return 0;
//        }
//        int sum = prevSum * 10 + root.val;
//        if (root.left == null && root.right == null) {
//            return sum;
//        } else {
//            return dfs(root.left, sum) + dfs(root.right, sum);
//        }
//    }
//}
//
//作者：力扣官方题解
//链接：https://leetcode.cn/problems/sum-root-to-leaf-numbers/solutions/464666/qiu-gen-dao-xie-zi-jie-dian-shu-zi-zhi-he-by-leetc/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。