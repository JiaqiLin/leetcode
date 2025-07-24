package kamacoder.tree.q23;

import java.util.Scanner;


class Main{
    public static String preOrder;
    public static String inOrder;

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            preOrder = scanner.nextLine();
            inOrder = scanner.nextLine();
            int height = getHeight(0,preOrder.length(),0,inOrder.length());
            System.out.println(height);
        }
    }

    public static int getHeight(int preStart,int preEnd,int inStart,int inEnd){
        if(preStart==preEnd){
            return 0;
        }
        if(preEnd-preStart==1){
            return 1;
        }
        int rootIn = inOrder.indexOf(preOrder.charAt(preStart));
        int leftLength = rootIn-inStart;
        return Math.max(getHeight(preStart+1,preStart+1+leftLength,inStart,inStart+leftLength),getHeight(preStart+1+leftLength,preEnd,inStart+leftLength+1,inEnd))+1;
    }
}