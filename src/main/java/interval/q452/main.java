package interval.q452;

public class main {
    public static void main(String[] args) {
//        int[][] points = new int[][]{{-2147483646,-2147483645},{2147483646,2147483647}};
        int[][] points = new int[][]{{10,16},{2,8},{1,6},{7,12}};
        Solution solution = new Solution();
        Integer result = solution.findMinArrowShots(points);
        System.out.println(result);
    }
}
