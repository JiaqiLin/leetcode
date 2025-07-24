package kamacoder.tree.q21;

import java.util.Scanner;


class Main{
    public static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int val, TreeNode left,TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
        public TreeNode(int val){
            this.val = val;
        }
    }


    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String s = scanner.nextLine();
            String[] sList = s.split(" ");
            TreeNode root = buildTreeByPreorderAndMidorder(sList[0],0,sList[0].length(),sList[1],0,sList[1].length());
            backOrder(root);
            System.out.println();

        }
    }

    public static TreeNode buildTreeByPreorderAndMidorder(String preOrder,int preStart,int preEnd,String midOrder,int midStart,int midEnd){
        if(preStart==preEnd){
            return null;
        }
        if(preEnd-preStart==1){
            return new TreeNode(preOrder.indexOf(preStart));
        }
        TreeNode root = new TreeNode(preOrder.indexOf(preStart));
        //找分界处
        int i=midStart;
        for(;i<midEnd;i++){
            if(midOrder.indexOf(i)==preOrder.indexOf(preStart)){
                break;
            }
        }
        int leftLength = i-midStart;
        int rightLength = midEnd-i-1;
        root.left = buildTreeByPreorderAndMidorder(preOrder,preStart+1,preStart+1+leftLength,midOrder,midStart,midStart+leftLength);
        root.right = buildTreeByPreorderAndMidorder(preOrder,preStart+1+leftLength,preEnd,midOrder,midStart+1+leftLength,midEnd);
        return root;
    }

    public static void backOrder(TreeNode root){
        if(root==null){
            return;
        }
        backOrder(root.left);
        backOrder(root.right);
        System.out.print(root.val);
    }
}