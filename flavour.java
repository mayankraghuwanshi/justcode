class main{
    static long factorial(long n){
        long fact =1;
        for(long i=1;i<=n;i++){
            fact*=i;
        }
        return fact;
    }
    static long combination(long n , long k){
        return (factorial(n)/(factorial(n-k)*factorial(k)));
    }
    public static void main(String args[]){
        long n = 5;
        long k =3;
        long res = n;
        for(int i=2;i<=k;i++){
            res+=combination(n,k);
        }
        System.out.println(res);
    }
}