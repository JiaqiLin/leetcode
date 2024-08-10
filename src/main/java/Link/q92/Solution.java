package Link.q92;

import Link.ListNode;

public class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left==right){
            return head;
        }
        //获取两端
        int i = 2,j = 2;
        ListNode start = head;
        ListNode end = head;
        while(i<=left-1&&start!=null) {
            start = start.next;
            i++;
        }
        while(j<=right+1&&end!=null) {
            end = end.next;
            j++;
        }
        ListNode reverseStart = null;
        // 获取要反转的开头

        if(start!=null&&start.next!=null){
            if (left == 1) {
                reverseStart = start;
            } else{
                reverseStart = start.next;
            }

        }
        // 遍历所有要反转的结点，依次拼接到end上
        int k = 0;
        while(k<=right-left&&reverseStart!=null){
            //记录下一个要换的结点
            ListNode temp = reverseStart.next;
            reverseStart.next = end;
            end = reverseStart;
            reverseStart = temp;
            k++;
        }

        //把start和end拼上
        if(left==1){
            head = end;
        }else {
            start.next = end;
        }


        return head;
    }


    public ListNode reverseBetweenDummyNode(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode start = dummyNode;
        for(int i=0;i<left-1;i++){
            start = start.next;
        }
        ListNode end = dummyNode;
        for(int i=0;i<right+1;i++){
            end = end.next;
        }
        // 获取要反转的开头
        ListNode reverseStart = start.next;



        // 遍历所有要反转的结点，依次拼接到end上
        int k = 0;
        while(k<=right-left&&reverseStart!=null){
            //记录下一个要换的结点
            ListNode temp = reverseStart.next;
            reverseStart.next = end;
            end = reverseStart;
            reverseStart = temp;
            k++;
        }

        //把start和end拼上
        start.next = end;


        return dummyNode.next;
    }
}


