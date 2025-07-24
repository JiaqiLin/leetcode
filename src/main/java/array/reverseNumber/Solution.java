package array.reverseNumber;

import java.util.Scanner;

public class Solution {

    private static int result;

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt()){
            result = 0;
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = scanner.nextInt();
            }
            mergeSort(0,n-1,arr,new int[n]);
            for(int i=0;i<n;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println(result);
        }
    }


    public static void mergeSort(int low,int high,int[] arr,int[] temp){
        if(low>=high){
            return;
        }
        int mid = (low+high)/2;
        mergeSort(low,mid,arr,temp);
        mergeSort(mid+1,high,arr,temp);

        merge(arr,temp,low,mid,high);

    }
    public static void merge(int[] arr, int[] temp,int low,int mid, int high){
        int i = low;
        int j = mid+1;
        int k = low;
        while (i<=mid&&j<=high){
            if(arr[i]<arr[j]){
                temp[k] = arr[i];
                i++;
                k++;
            }else{
                result+=(mid-i+1);
                temp[k] = arr[j];
                j++;
                k++;
            }
        }
        while(i<=mid){
            temp[k] = arr[i];
            k++;
            i++;
        }
        while(j<=high){
            temp[k] = arr[j];
            k++;
            j++;
        }

        for(int q=low;q<=high;q++){
            arr[q] = temp[q];
        }
    }


}
