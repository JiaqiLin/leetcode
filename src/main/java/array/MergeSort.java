package array;

import java.util.Scanner;

public class MergeSort {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt()){
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = scanner.nextInt();
            }
            mergeSort(arr,0,n-1,new int[n]);
            for(int i=0;i<n;i++){
                System.out.print(arr[i]+" ");
            }
        }
    }

    public static void mergeSort(int arr[],int low, int high,int[] temp){
        if(low>=high){
            return;
        }
        int mid = (low+high)/2;
        mergeSort(arr,low,mid,temp);
        mergeSort(arr,mid+1,high,temp);

        merge(arr,low,mid,high,temp);

    }

    public static void merge(int arr[], int low,int mid,int high,int[] temp){
        int i = low,j = mid+1;
        int k = low;
        while(i<=mid&&j<=high){
            if(arr[i]<arr[j]){
                temp[k] = arr[i];
                i++;
            }else{
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        while(i<=mid){
            temp[k] = arr[i];
            i++;
            k++;
        }
        while(j<=high){
            temp[k] = arr[j];
            j++;
            k++;
        }

        for(int r=low;r<=high;r++){
            arr[r] = temp[r];
        }
    }
}
