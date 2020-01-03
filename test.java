import java.util.*;
class main{
    public static void main (String args[]) {
		Scanner scn = new Scanner(System.in);
		int f = scn.nextInt();
		int n =5;
		int res=0;
		while(f/n>0){
			res+=f/n;
			n*=5;
		}
		System.out.println(res);
    }
}
