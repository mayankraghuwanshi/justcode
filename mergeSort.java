import java.util.Arrays;
class main{
    static void swap(int arr[] , int i , int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    static void merge(int arr[] ,int i, int size1 ,int j, int size2){
        int k = i<j?i:j;
        // int i=0;
        // int j=0;
        while((i<size1 || j<size2) && k<arr.length){
            if(i<size1 && j<size2){
                if(arr[i]<arr[j]){
                    swap(arr,i,k);
                    i++;
                    k++;
                }else{
                    swap(arr,j,k);
                    j++;
                    k++;
                }
            }else if(i<size1){
                swap(arr,i,k);
                i++;
                k++;
            }else if(j<size2){
                swap(arr,j,k);
                j++;
                k++;
            }
        }
    }
    static void mergeSort(int arr[] , int start , int end){
        if(start==end) return;
        int pivote = start+(end-start)/2;
        mergeSort(arr,start,pivote);
        mergeSort(arr,pivote+1,end);
        merge(arr,start , pivote,pivote+1,end);
    }
    public static void main(String args[]){
        int arr[] = {1,7,3,8,4,2,5,7};
        mergeSort(arr,0,arr.length-1);
        // System.out.println(Arrays.toString(arr));
        merge(arr,0,3,4,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}