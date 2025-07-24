package array;

import java.util.Scanner;

public class QuickSort {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt()){
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = scanner.nextInt();
            }
            quicksort(arr,0,n-1);

            for(int i=0;i<n;i++){
                System.out.print(arr[i]+" ");
            }
        }

    }

    public static void quicksort(int[] arr,int i,int j){
        if(i<j){
           int k = partition(arr,i,j);

           quicksort(arr, i, k-1);
           quicksort(arr, k+1, j);
        }


    }

    public static int partition(int[] arr,int low,int high){
        int temp = arr[low];
        int i =low,j=high;
        while(i<j){
            while(i<=high&&arr[i]<=temp){
                i++;
            }
            while(j>=low&&arr[j]>temp){
                j--;
            }
            if(i<j){
                swap(arr, i, j);
            }
        }
        swap(arr,low,j);
        return j;
    }

    public static void swap(int[] arr, int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
