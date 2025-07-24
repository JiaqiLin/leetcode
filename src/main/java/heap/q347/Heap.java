package heap.q347;

import java.util.List;

public class Heap {


    public void adjustHeap(int[] nums, int i, int n){
        for(int s=2*i+1;s<=n;s=2*i+1){
            if(s+1<=n&&nums[s]<nums[s+1]){
                s+=1;
            }
            if(nums[s]>nums[i]){
                int temp = nums[i];
                nums[i] = nums[s];
                nums[s] = temp;
                i = s;
            }else {
                break;
            }

        }
    }

    public void createHeap(int[] nums){
        int n = nums.length;
        for(int i=n/2-1;i>=0;i--){
            adjustHeap(nums,i,n-1);
        }
    }


    public void sortHeap(int[] nums){
        createHeap(nums);
        int n = nums.length;
        for(int i=0;i<n;i++){
            int temp = nums[0];
            nums[0] = nums[n-1-i];
            nums[n-1-i] = temp;
            adjustHeap(nums,0,n-2-i);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,4,3,2,1};
        Heap heap = new Heap();
        heap.sortHeap(nums);
        for(int num:nums){
            System.out.println(num);
        }


    }
}
