package Link.q19;

import Link.ListNode;

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int i = 1;
        ListNode p = head;
        while(i!=n){
            p = p.next;
            i+=1;
        }
        ListNode q = dummy;
        ListNode r = head;

        while(p.next!=null){
            q = q.next;
            r = r.next;
            p = p.next;
        }

        q.next = r.next;

        return dummy.next;

    }
}
