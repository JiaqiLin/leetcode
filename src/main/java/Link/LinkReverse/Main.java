package Link.LinkReverse;

import java.util.Scanner;
class Node{
    Node next;
    int data;
    public Node(int data, Node next){
        this.data = data;
        this.next = next;
    }
    public Node(int data){
        this.data = data;
        this.next = null;
    }
}
class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(true){
            int n = scanner.nextInt();

            if(n==0){
                System.out.println("list is empty");
                continue;
            }

            Node dummyNode = new Node(-1);
            Node p = dummyNode;

            for(int i=0;i<n;i++){
                Node newNode = new Node(scanner.nextInt());
                p.next = newNode;
                p = p.next;
            }
            Node q = dummyNode.next;
            while(q!=null){
                System.out.print(q.data);
                if(q.next!=null){
                    System.out.print(' ');
                }else{
                    System.out.println();
                }
                q = q.next;
            }

            Node lastNode = p;
            Node tail = reverse(dummyNode.next);
            tail.next = null;
            q = lastNode;

            while(q!=null){
                System.out.print(q.data);
                if(q.next!=null){
                    System.out.print(' ');
                }else{
                    System.out.println();
                }
                q = q.next;
            }

        }
    }
    public static Node reverse(Node p){
        if(p.next==null){
            return p;
        }
        Node tail = reverse(p.next);
        tail.next = p;
        return p;
    }
}