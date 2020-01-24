import java.util.Arrays;
class main{
    static int[] merge(int left[] , int right[]){
        int i=0;
        int j=0;
        int k=0;
        int res[] = new int[left.length+right.length];
        while(i<left.length && j<right.length){
            if(left[i]<right[j]){
                res[k++]=left[i++];
            }else{
                res[k++]=right[j++];
            }
        }
        while(i<left.length){
            res[k]=left[i];
            i++;
            k++;
        }
        while(j<right.length){
            res[k]=right[j];
            j++;
            k++;
        }
        return res;
    }
    // {1,7,3,8,4,2,5,7};
    // 1,7,3,8 | 4,2,5,7
    // 1,7     |     3,8
    // 1 | 7         3 | 8
    //[1,7]   |     [3,8]
    //[1,3,7,8]   
    static int [] mergeSort(int arr[] , int l , int r){
            if(l==r){
                int res[] = new int[1];
                res[0]=arr[r];
                return res;
            } 
            int pivote = (l+r)/2;
            int arr1[] = mergeSort(arr,l,pivote);
            int arr2[] = mergeSort(arr,pivote+1,r);
            return merge(arr1,arr2);
    }  
        // 0 1 2 3 4 5 6 7
    // {1,3,4,2,5,7,7,8|}
                //   ^    ^ 

    
    

    public static void main(String args[]){
        int arr[] = {1,7,3,8,4,2,5,7};
        System.out.println(Arrays.toString(mergeSort(arr,0,arr.length-1)));
    }
}