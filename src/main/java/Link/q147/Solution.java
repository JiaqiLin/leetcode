package Link.q147;


import Link.ListNode;

public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode p = head;

        if(head==null){
            return null;
        }
        ListNode resultDummyHead = new ListNode(-1,null);

        while(p!=null){
            ListNode q = resultDummyHead;
            ListNode r = resultDummyHead.next;
            while(r!=null&&r.val<= p.val){
                r = r.next;
                q = q.next;
            }
            ListNode temp = p.next;
            q.next = p;
            p.next = r;
            p = temp;
        }
        return resultDummyHead.next;

    }
}
