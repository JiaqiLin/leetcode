package Link.q19;

import Link.ListNode;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int nums = sc.nextInt();
            ListNode dummy = new ListNode(0);
            ListNode cur = dummy;
            for (int i = 0; i < nums; i++) {
                cur.next = new ListNode(sc.nextInt());
                cur = cur.next;
            }
            int n = sc.nextInt();

            Solution solution = new Solution();
            solution.removeNthFromEnd(dummy.next,n);

            ListNode p = dummy.next;
            while(p!=null){
                System.out.print(p.val);
                System.out.print(" ");
                p = p.next;
            }
            System.out.println();
        }

    }
}
