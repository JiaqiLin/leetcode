package interval.q452;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int findMinArrowShots(int[][] points) {
        //按照右端升序排序
//        Arrays.sort(points,(a, b)->a[1]-b[1]);
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] point1, int[] point2) {
                if (point1[1] > point2[1]) {
                    return 1;
                } else if (point1[1] < point2[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        int result = 1;
        int lastArrow = points[0][1];
        for (int i = 1;i< points.length;i++) {
            if(points[i][0]>lastArrow){
                lastArrow = points[i][1];
                result+=1;
            }

        }
        return result;
    }
}
