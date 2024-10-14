// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
public class HeapSort {
     public static void heapify(int arr[],int i, int size){
         int left=2*i+1;
         int right=2*i+2;
         int maxInd=i;
         if(left<size && arr[left]>arr[maxInd]){
             maxInd=left;
         }
           if(right<size && arr[right]>arr[maxInd]){
             maxInd=right;
         }
         if(i!=maxInd){
                int temp=arr[maxInd];
            arr[maxInd]=arr[i];
            arr[i]=temp;
             heapify(arr,i,size);
         }
     }
    public static void heapSort(int arr[]){
        int n=arr.length;
        for(int i=n/2;i>=0;i--){
            heapify(arr,i,n);
        }
        for(int i=n-1;i>0;i--){
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            heapify(arr,0,i);
        }
    }
    public static void main(String[] args) {
       int arr[]={2,3,5,1,4};
       heapSort(arr);
       for(int i=0;i<arr.length;i++){
           System.out.print(arr[i]+" ");
       }
        System.out.println();
    }
}