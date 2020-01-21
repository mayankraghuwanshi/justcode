import java.util.*;
class main{
    static int getFact(int n){
        if(n<0) return 0;
        int fact=1;
        for(int i=1;i<=n;i++){
            fact*=i;
        }
        return fact;
    }
    public static void main(String args[]){

        Scanner scn = new Scanner(System.in);
        for(int tc=scn.hasNextInt()?scn.nextInt():0;tc>0;tc--){
            int n = scn.hasNextInt()?scn.nextInt():0;
            int sum=0;
            int arr[] = new int[2*n];
            Hashtable<Integer,Integer> map = new Hashtable<>();
            ArrayList<Integer> elementAtLast = new ArrayList<>();
            for(int i=0;i<2*n;i++){
                int  temp = scn.hasNextInt()?scn.nextInt():0;
                sum+=temp;
                if(map.contains(temp)){
                    int freq = map.get(temp)+1;
                    map.put(temp , freq);
                    if(freq==2) elementAtLast.add(temp);
                }else{
                    map.put(temp,1);
                }
            }
            for(int i=0;i<elementAtLast.size();i++){
                boolean isDone = true;
                int freq = map.get(elementAtLast.get(i))-2;
                HashSet<Integer> set = new HashSet<>();
                ArrayList<Integer> freqUni = new ArrayList<>();
                for(int j=0;j<2*n;j++){
                    if(set.get(arr[j]!=set.get(set.size()))){
                        contains;
                    }
                    if(map.get(arr[j])>0){
                        if(map.contains(elementAtLast.get(i)-arr[j]) && map.get(elementAtLast.get(i)-arr[j]) ))
                    }
                }

            }
        }
            
    }
}