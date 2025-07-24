package Link.q25;

import java.util.List;

//0123456789  () !
class Solution {
      static class ListNode {
      int val;
      ListNode next;
      public ListNode() {}
      public ListNode(int val) { this.val = val; }
      public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
    public ListNode reverseKGroup(ListNode head, int k) {
         ListNode dummy = new ListNode(-1);
         dummy.next = head;
        ListNode p = dummy;
        ListNode q = dummy;
        //int i=0;
         while(q!=null){
             for(int i=0;i<k;i++){
                 q =q.next;
                 if(q==null){
                     return dummy.next;
                 }
             }
             ListNode subList = p.next;
             ListNode endList = q.next;
             q.next = null;
             ListNode newSubList = reverseList(subList);
             p.next = newSubList;
             subList.next = endList;

             p = subList;
             q = subList;

         }

         return dummy.next;

    }

    public ListNode reverseList(ListNode head){
         ListNode pre = null;
         ListNode cur = head;
         while(cur!=null){
             ListNode temp = cur.next;
             cur.next = pre;
             pre = cur;
             cur = temp;
         }
         return pre;
    }

    public ListNode reverseList2(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr= new int[]{1,2,3,4,5};
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        for(int i=0;i<arr.length;i++){
            p.next = new ListNode(arr[i]);
            p = p.next;
        }
        int k = 2;
        solution.reverseKGroup(dummy.next,k);


    }
}