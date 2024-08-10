package hashTable.q1;

import java.util.Hashtable;

class Solution {
    public int[] twoSum(int[] nums, int target) {

        Hashtable<Integer,Integer> hashtable = new Hashtable<>();   //<数字，位置>
        int [] result = new int[2];
        for (int i = 0;i< nums.length;i++) {
            // 和我配对的在里面
            if(hashtable.get(target - nums[i])!=null){
                result[0] = hashtable.get(target - nums[i]);
                result[1] = i;
                break;
            }else {//不在里面，把自己加进去
                hashtable.put(nums[i],i);
            }
        }
        return result;
    }
}