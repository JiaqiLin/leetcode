package hashTable.q1;

public class main {
    public static void main(String[] args) {
        int []nums = new int[]{2,7,11,15};
        int target = 9;
        Solution solution = new Solution();
        int []result = solution.twoSum(nums,target);
        System.out.println(result);
    }
}
