import java.util.*;
class main{
    static void quickSort(int arr[] , int start, int end){
        // if(start>=end) return;
        if(start<end){
            int pivote = partition(arr , start , end);
            quickSort(arr,start,pivote-1);
            quickSort(arr,pivote+1,end);
        }
    }
    static int partition(int arr[] , int start , int end){
        int pivote = arr[end];
        for(int i=start;i<=end;i++){
            if(arr[i]<pivote){
                int temp = arr[i];
                arr[i] = arr[start];
                arr[start] = temp;
                start++;
            }
        }
        int temp = arr[end];
        arr[end]=arr[start];
        arr[start]=temp;
        return start;
    }

    public static void main(String args[]){
        int arr[] = {1,21,2,43,11,23,54,77,545,23,54,5,3,43,32,424,35,4323,4};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}