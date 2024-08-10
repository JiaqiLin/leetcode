package Link;

public class DoubleLinkNode {
    public int key;
    public int val;

    public DoubleLinkNode prev;
    public DoubleLinkNode next;
    public DoubleLinkNode(){

    }
    public DoubleLinkNode(int key,int val){
        this.key = key;
        this.val = val;
    }
    public DoubleLinkNode(int key, int val,DoubleLinkNode prev, DoubleLinkNode next){
        this.key = key;
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
}
