import java.util.*;
class main{
    static int binarySearch(int val, ArrayList<Integer> arr){
        int s = 0;
        int e = arr.size()-1;
        int m = 0;
        if(val<arr.get(s)) return s;
        else if(val>arr.get(e)) return e+1;
        while(s<=e){
            m = s+(e-s)/2;
            int midVal = arr.get(m);
            if(midVal==val) s=m+1;
            else if(midVal>val) e=m-1;
            else s=m+1;
        }
        
        return m;
    }

    static void Merge(ArrayList<Integer> a1 , ArrayList<Integer> a2){
        for(int i=0;i<a2.size();i++){
            int index = binarySearch(a2.get(i), a1);
            a1.add(index, a2.get(i));
        }
        System.out.println(a1);
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(-4,-3,0));
        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(2));
        Merge(arr1, arr2);
        
    }
}