
import java.util.*;
class main{
    static int solve(ArrayList<Integer> a1 , ArrayList<Integer> a2 , ArrayList<Integer> a3){
        int i=0;
        int j=0;
        int k=0;
        int l=0;
        int arr[] = new int[3];
        int min = Integer.MAX_VALUE;
        while(i<a1.size() && j<a2.size() && k<a3.size()){
            if(i<a1.size() && j<a2.size() && k<a3.size()){
                if(a1.get(i)<=a2.get(j) && a1.get(i)<=a3.get(k)){
                    arr[l%3]=a1.get(i);
                    l++;
                    i++;
                }else if(a2.get(j)<=a1.get(i) && a2.get(j)<=a3.get(k)){
                    arr[l%3]=a2.get(j);
                    j++;
                    l++;
                }else if(a3.get(k)<=a1.get(i) && a3.get(k)<=a2.get(j)){
                    arr[l%3]=a3.get(k);
                    k++;
                    l++;
                }
            }
            else if(i<a1.size() && j<a2.size()){
                if(a1.get(i)<=a2.get(j)){
                    arr[l%3]=a1.get(i);
                    i++;
                    l++;
                }else{
                    arr[l%3]=a2.get(j);
                    j++;
                    l++;
                }
            }else if(j<a2.size() && k<a3.size()){
                if(a2.get(j)<=a3.get(k)){
                    arr[l%3]=a2.get(j);
                    j++;
                    l++;
                }else{
                    arr[l%3]=a3.get(k);
                    k++;
                    l++;
                }
            }else if(i<a1.size()){
                arr[l%3]=a1.get(i);
                i++;
                l++;
            }else if(j<a2.size()){
                arr[l%3]=a2.get(j);
                j++;
                l++;
            }else if(k<a3.size()){
                arr[l%3]=a3.get(i);
                k++;
                l++;
            }
            System.out.println(Arrays.toString(arr));
            if(l>3) min = Math.min(min,getMinMaxDif(arr));
        }
        return min;
    }

    static int getMinMaxDif(int arr[]){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<3;i++){
            min=Math.min(min,arr[i]);
            max=Math.max(max,arr[i]);
        }
        return max-min;
    }
    public static void main(String args[]){
        ArrayList<Integer> a1 = new ArrayList<Integer>(Arrays.asList( 1, 4, 5, 8, 10));
        ArrayList<Integer> a2 = new ArrayList<Integer>(Arrays.asList( 6, 9, 15));
        ArrayList<Integer> a3 = new ArrayList<Integer>(Arrays.asList( 2, 3, 6, 6 ));
        System.out.println(solve(a1,a2,a3));
    }
}