package heap.q347;

import java.util.List;

public class GeneralHeap {
    public static <T extends Comparable<T>> void  adjustHeap(List<T> nums, int i, int n){
        for(int s=2*i+1;s<=n;s=2*i+1){
            if(s+1<=n&&nums.get(s).compareTo(nums.get(s+1))<0){
                s+=1;
            }
            if(nums.get(s).compareTo(nums.get(i))>0){
                T temp = nums.get(i);
                nums.set(i,nums.get(s));
                nums.set(s,temp);
                i = s;
            }else {
                break;
            }

        }
    }

    public static <T extends Comparable<T>> void  createHeap(List<T> nums){
        int n = nums.size();
        for(int i=n/2-1;i>=0;i--){
            adjustHeap(nums,i,n-1);
        }
    }

    public static <T extends Comparable<T>> void sortHeap(List<T> nums){
        createHeap(nums);
        int n = nums.size();
        for(int i=0;i<n;i++){
            T temp = nums.get(0);
            nums.set(0,nums.get(n-1-i));
            nums.set(n-1-i,temp);
            adjustHeap(nums,0,n-2-i);
        }
    }
}
