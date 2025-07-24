package heap.q295;

import java.util.Comparator;
import java.util.PriorityQueue;

class MedianFinder {
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;
    public MedianFinder() {
        this.minHeap = new PriorityQueue<>();
        this.maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2){
                return o2-o1;
            }
        });
    }

    public void addNum(int num) {
        if(maxHeap.isEmpty()||num<=maxHeap.peek()){
            maxHeap.add(num);
        }else{
            minHeap.add(num);
        }
        while(Math.abs(maxHeap.size()-minHeap.size())>1){
            if(maxHeap.size()>minHeap.size()){
                minHeap.add(maxHeap.poll());
            }else{
                maxHeap.add(minHeap.poll());
            }
        }
    }

    public double findMedian() {
        if(maxHeap.size()>minHeap.size()){
            return maxHeap.peek();
        }else if(maxHeap.size()<minHeap.size()){
            return minHeap.peek();
        }else{
            return (maxHeap.peek()+minHeap.peek())/2;
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());;
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());;
    }
}

