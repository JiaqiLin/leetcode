package graph.q299;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Solution {

    double accumulate = 1;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        double[][] adjMatrix = new double[26][26];
        boolean[] visited = new boolean[26];
        for(int i=0;i<26;i++){
            adjMatrix[i][i] = 1;
        }
        for(int i=0;i<equations.size();i++){
            List<String> equation = equations.get(i);
            adjMatrix[equation.get(0).charAt(0)-97][equation.get(1).charAt(0)-97] = values[i];
            adjMatrix[equation.get(1).charAt(0)-97][equation.get(0).charAt(0)-97] = 1/values[i];
        }
        double[] result = new double[queries.size()];
        for(int i=0;i<queries.size();i++){
            List<String> query = queries.get(i);
            if(dfs(adjMatrix,visited,query.get(0).charAt(0)-97,query.get(1).charAt(0)-97)){
                result[i] = accumulate;
            }else{
                result[i] = -1;
            }
            accumulate = 1;

        }
        return result;

    }

    public boolean dfs(double[][] adjMatrix,boolean[] visited,int current,int end){
        visited[current]=true;
        if(current==end){
            return true;
        }
        for(int i=0;i<26;i++){
            if(Double.doubleToLongBits(adjMatrix[current][i])!=Double.doubleToLongBits(0)&&visited[i]==false){
                accumulate*=adjMatrix[current][i];
                if(dfs(adjMatrix,visited,i,end)){
                    return true;
                }
                accumulate/=adjMatrix[current][i];
            }
        }
        visited[current] = false;
        return false;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("a", "b"));
        equations.add(Arrays.asList("b", "c"));


        double[] values = new double[]{2.0,3.0};
        List<List<String>> queries = new ArrayList<>();
//        queries.add();
//        queries.add();
//        queries.add();
//        queries.add();
//        queries.add();

        //Scanner
    }

}



