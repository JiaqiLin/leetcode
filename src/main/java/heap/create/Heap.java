package heap.create;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Heap {
    public ArrayList<Integer> heapArr;
    public void maxHeapify(int k){
        while(2*k+1<heapArr.size()){
            int changeIndex = k;
            if(heapArr.get(k)<heapArr.get(2*k+1)){
                swap(k,2*k+1);
                changeIndex = k*2+1;
            }
            if(2*k+2<heapArr.size()&&heapArr.get(k)<heapArr.get(2*k+2)){
                swap(k,2*k+2);
                changeIndex = 2*k+2;
            }
            k = changeIndex;

        }
    }
    public void swap(int i,int j){
        int temp = heapArr.get(i);
        heapArr.set(i,heapArr.get(j));
        heapArr.set(j,temp);
    }
    public Heap(){
        heapArr = new ArrayList<>();
    }

    public Heap(int[] arr){
        heapArr = new ArrayList<>();
        int n = arr.length;
        for(int num:arr){
            heapArr.add(num);
        }
        for(int i=n/2;i>=0;i--){
            this.maxHeapify(i);
        }
    }

    public int poll(){
        int result = heapArr.get(0);
        swap(0,heapArr.size()-1);
        maxHeapify(0);
        heapArr.remove(size()-1);
        return result;
    }

    public Integer peek(){
        return heapArr.get(0);
    }

    public void add(int num){
        heapArr.add(num);
        int i = heapArr.size()-1;
        while(i>=1){
            int parent;
            if(i%2==0){
                parent = (i-2)/2;
            }else{
                parent = (i-1)/2;
            }
            if(heapArr.get(parent)<heapArr.get(i)){
                swap(parent,i);
            }else{
                break;
            }
            i = parent;
        }
    }

    public int size(){
        return heapArr.size();
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        Heap heap = new Heap(nums);
        heap.add(6);
        System.out.println(heap.peek());

    }
}
