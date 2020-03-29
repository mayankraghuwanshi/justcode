import java.util.*;
class main{


    static int binarySearch(int start,  int key , List<Integer> arr){
        if(start==arr.size() || start<0) return -1;
        if(arr.size()==0) return -1;
        int end = arr.size()-1;
        if(arr.get(start)>key) return -1;
        if(arr.get(end)<key) return -1;
        while(start<=end){
            int mid = start+(end-start)/2;
            int midElement =arr.get(mid);
            if(midElement==key){
                if(mid-1>=start && arr.get(mid-1)==key){
                    end=mid-1;
                }else return mid;
            }else if(midElement>key){
                end=mid-1;
            }else start = mid+1;
        }

        return -1;
    }
    public static ArrayList<Integer> intersect(final List<Integer> A, final List<Integer> B) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        int lastIndex =0 ;
        for(int i=0;i<A.size();i++){
            int index = binarySearch(lastIndex, A.get(i), B);
            // if(A.get(i)==44) System.out.println(index);
            if(index!=-1){
                res.add(A.get(i));
                lastIndex=++index;
            }
        }
        return res;
    }
    public static void main(String args[]){
        List<Integer> arr1 = new ArrayList<>(Arrays.asList(1,2,3,44,44,44));
        List<Integer> arr2 = new ArrayList<>(Arrays.asList(1,2,3,4,12,43,44,44,44,123));
        System.out.println(intersect(arr1, arr2));
    }
}