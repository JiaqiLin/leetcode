package queue;

import java.util.Scanner;
import  java.util.List;
import java.util.ArrayList;

class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<n;i++){
            arr[i] = scanner.nextInt();
            list.add(arr[i]);
        }
        int result = 0;
        while(list.size()>1){
            List newlist = new ArrayList<Integer>();
            for(int i=0;i<list.size();i++){
                if(i==0){
                    newlist.add(list.get(i));
                }else{
                    if(list.get(i-1)<=list.get(i)){
                        newlist.add(list.get(i));
                    }
                }

            }
            list = newlist;
            result+=1;
        }
        System.out.println(result);

    }
}
