class main{
    static void print(long val){
        System.out.println(val);
        System.out.flush();
    }
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        for(int tc=scn.hasNextInt()?scn.nextInt():0;tc>0;tc--){
            long n = scn.hasNextLong()?scn.nextLong():0;
            long a = scn.hasNextLong()?scn.nextLong():0;
            long s=Math.pow(10,n);
            print(2*s+a); //s
            long b = scn.hasNextLong()?scn.nextLong():0;
            print(s-b);  //c
            long d = scn.hasNextLong()?scn.nextLong():0;
            print(s-c); //e
            int temp = long a = scn.hasNextLong()?scn.nextLong():0;
            if(temp==-1) break;            
        }
    }
}