class main{
    static void check(int i){
        System.out.println(i);
    }
    static int maxProfit(int arr[]){
        int len = arr.length;
        int min []  = new int[len];
        int max[] = new int[len];
        min[0]=arr[0];
        max[len-1]=arr[len-1];
        // check(0);
        for(int i=1;i<len;i++){
            min[i] = Math.min(min[i-1],arr[i]);
        }
        // check(0);
        for(int i=len-2;i>=0;i--){
            max[i] = Math.max(max[i+1],arr[i]);
        }
        // check(0);
        int res = Integer.MIN_VALUE;
        for(int i=0;i<len;i++){
            res=Math.max(res,max[i]-min[i]);
        }
        // check(0);
        return res;
    }
    public static void main(String args[]){
        int arr[] = {7,1,5,3,6,4};

        System.out.println(maxProfit(arr));
    }
}