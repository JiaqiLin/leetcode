package hashTable.q219;

public class main {

    public static void main(String[] args) {
//        int[] nums = new int[]{1,2,3,1};
//        int k = 3;

        int[] nums = new int[]{1,2,3,1,2,3};
        int k =2;
        Solution solution = new Solution();
        Boolean result = solution.containsNearbyDuplicate(nums,k);
        System.out.println(result);
    }
}
