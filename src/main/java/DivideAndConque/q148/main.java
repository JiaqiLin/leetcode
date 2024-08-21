package DivideAndConque.q148;

import Link.q147.Solution;

public class main {
    public static void main(String[] args) {
        int[] head = new int[]{4,2,1,3};
        ListNode listNode = null;
        ListNode p = null;
        for(int i=0;i<head.length;i++){
            if(i==0){
                listNode = new ListNode(head[0]);
                p = listNode;
            }else {
                listNode.next = new ListNode(head[i]);
                listNode = listNode.next;
            }
            if(i==head.length-1){
                listNode.next = null;
            }

        }

        Solution solution = new Solution();
//        ListNode result = solution.sortList(p);
//        System.out.println(result);
    }
}
