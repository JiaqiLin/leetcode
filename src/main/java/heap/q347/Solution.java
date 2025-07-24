package heap.q347;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    static class GeneralHeap {
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

    static class CustomMapEntry<K , V extends Comparable<V>> implements Map.Entry<K, V>, Comparable<CustomMapEntry<K, V>> {
        private K key;
        private V value;

        public CustomMapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            this.value = value;
            return value;
        }

        @Override
        public int compareTo(CustomMapEntry<K, V> other) {
            return this.value.compareTo(other.getValue());  // 基于 key 进行排序
        }

    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> times = new HashMap<>();
        for(int num:nums){
            times.put(num,times.getOrDefault(num,0)+1);
        }

        int[] result = new int[k];
        List<CustomMapEntry<Integer,Integer>> newNums = new ArrayList<>();

        for(Map.Entry<Integer,Integer> entry: times.entrySet()){
            newNums.add(new CustomMapEntry<>(entry.getKey(), entry.getValue()));
        }

        GeneralHeap.sortHeap(newNums);
        for(int i=0;i<k;i++){
            result[i] = newNums.get(newNums.size()-1-i).getKey();
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1,1,1,2,2,3,3,3,3};
        int[] result = solution.topKFrequent(nums,3);
        for(int num:result){
            System.out.println(num);
        }
    }
}
