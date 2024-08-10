package Link.q92;


import Link.ListNode;

public class main {
    public static void main(String[] args) {
//        String[] tokens = new String[]{"2","1","+","3","*"};
//        Solution solution = new Solution();
//        System.out.println(solution.evalRPN(tokens));


        //输出：[1,4,3,2,5]
//        Integer[] numbers = new Integer[]{1,2,3,4,5};
//        int left = 2, right = 4;
        Integer[] numbers = new Integer[]{5};
        int left = 1, right = 1;
//        Integer[] numbers = new Integer[]{3,5};
//        int left = 1, right = 2;
        ListNode head = new ListNode(numbers[0]);
        ListNode p = head;
        for (int i = 1;i<numbers.length;i++) {
            ListNode q = new ListNode(numbers[i],null);
            p.next = q;
            p = p.next;
        }
        Solution solution = new Solution();
        solution.reverseBetweenDummyNode(head,left,right);
        ListNode q = head;
        while(q!=null) {
            System.out.println(q.val);
            q = q.next;
        }

    }
}
