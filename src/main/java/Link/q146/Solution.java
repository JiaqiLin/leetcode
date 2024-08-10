package Link.q146;

import Link.DoubleLinkNode;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    private int capacity;

    private int currentCount;
    private DoubleLinkNode dummyHead;
    private DoubleLinkNode dummytTail;
    private Map<Integer, DoubleLinkNode> hashTable;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.hashTable = new HashMap<Integer, DoubleLinkNode>();

        this.dummyHead = new DoubleLinkNode();
        this.dummytTail = new DoubleLinkNode();
        dummyHead.next = dummytTail;
        dummytTail.prev = dummyHead;

        currentCount = 0;

    }

    public int get(int key) {
        if (this.hashTable.containsKey(key)) {
            //将节点放到最前面
            DoubleLinkNode currentNode = hashTable.get(key);
            moveToHead(currentNode);
            return currentNode.val;
        } else {
            return -1;
        }


    }

    public void put(int key, int value) {
        //看原来有没有
        DoubleLinkNode node = hashTable.get(key);
        if (node == null) {
            if (this.currentCount == this.capacity) {  //容量满了
                //删除末尾
                DoubleLinkNode origin_tail = removeTail();
                hashTable.remove(origin_tail.key);
                currentCount -= 1;
            }
            DoubleLinkNode newNode = new DoubleLinkNode(key, value);
            //容量没满，直接插入
            this.addToHead(newNode);
            hashTable.put(key, newNode);
            currentCount += 1;
        } else {
            node.val = value;
            this.moveToHead(node);

        }


    }


    public void moveToHead(DoubleLinkNode node) {
        DoubleLinkNode prev = node.prev;
        DoubleLinkNode next = node.next;

        prev.next = next;
        next.prev = prev;

        DoubleLinkNode first_next = dummyHead.next;

        dummyHead.next = node;
        node.next = first_next;
        first_next.prev = node;
        node.prev = dummyHead;
    }

    public void addToHead(DoubleLinkNode node) {
        DoubleLinkNode head_next = dummyHead.next;
        dummyHead.next = node;
        node.next = head_next;
        head_next.prev = node;
        node.prev = dummyHead;
    }

    public void addToTail(DoubleLinkNode node) {
        DoubleLinkNode tail_prev = dummytTail.prev;
        tail_prev.next = node;
        node.next = dummytTail;
        dummytTail.prev = node;
        node.prev = tail_prev;
    }

    public DoubleLinkNode removeTail() {
        DoubleLinkNode prev = dummytTail.prev;
        prev.prev.next = dummytTail;
        dummytTail.prev = prev.prev;
        return prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
