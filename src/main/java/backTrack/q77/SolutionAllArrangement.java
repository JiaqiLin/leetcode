package backTrack.q77;

import java.util.ArrayList;
import java.util.List;

class SolutionAllArrangement {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        int[] numList = new int[n];
        for(int i = 0;i<n;i++){
            numList[i] = i+1;
        }
        backtrack(numList,0,result,k);
        return result;

    }

//    public int C(int n,int m) {
//        //分子
//        int son = 1;
//        //分母
//        int mother = 1;
//        // 应用组合数的互补率简化计算量
//        m = m > (n - m) ? (n - m) : m;
//        for(int i = m;i > 0; i--) {
//            //如果你还记得上面的求全排列数的实现，你应该会发现 son 就是在求 A(n，m)
//            son *= n;
//            mother *= i;
//            n--;
//        }
//        return son / mother;
//    }
    public void backtrack(int[] numList,int index ,List<List<Integer>> result,int k){
        if(index==k){
            List<Integer> currentResult = new ArrayList<>();
            for(int i=0;i<k;i++){
                currentResult.add(numList[i]);
            }
            result.add(currentResult);
            return;
        }

        for(int i = index;i<numList.length;i++){
            int temp = numList[index];
            numList[index] = numList[i];
            numList[i] = temp;
            backtrack(numList,index+1,result,k);
            int temp2 = numList[index];
            numList[index] = numList[i];
            numList[i] = temp2;
        }

    }
}
