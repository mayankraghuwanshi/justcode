import java.util.Arrays;
class main{
    static int maximize(int sticks[] , int desireLength , int noOfBreakAllow){
        int res=0;
        Arrays.sort(sticks);
        for(int i = sticks.length-1; i>=0;i--){
            int item = sticks[i];
            while(noOfBreakAllow>0 && item>=desireLength){
                item-=desireLength;
                noOfBreakAllow--;
                res++;
                if(item==desireLength){
                    item=0;
                    res++;
                }
            }
        }
        return res;
    }
    public static void main(String args[]){
        int sticks[] = {1,5,3,5,7,6,9,12,5,11};
        System.out.println(maximize(sticks,3,4));
    }
}