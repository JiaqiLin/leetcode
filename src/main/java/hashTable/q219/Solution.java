package hashTable.q219;

import java.util.HashMap;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> hashMap = new HashMap<Integer,Integer>();
        for(int i = 0;i<nums.length;i++){
            if(hashMap.get(nums[i])==null){
                hashMap.put(nums[i],i);
            }else {
                int index = hashMap.get(nums[i]);
                if(Math.abs(index-i)<=k){
                    return true;
                }else {
                    hashMap.put(nums[i],i);
                }
            }
        }
        return false;

    }
}
