/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc=new Scanner(System.in);
		    int n=sc.hasNextInt()?sc.nextInt():0;
		    int[] ar=new int[n];
		    int q=sc.hasNextInt()?sc.nextInt():0;
		    for(int i=0;i<n;++i){
		        ar[i]=sc.hasNextInt()?sc.nextInt():0;
		    }
		    int [] inc=new int[n];
		    int [] dec=new int[n];
		    int pt=1;
		    for(int i=1;i<n;++i){
		        i--;
		        if((i+1)<n){
		            if(ar[i]<ar[i+1]){
		                while(ar[i]<ar[i+1]){
		                    if(inc[i]==0)
		                    inc[i]=pt;
		                    i++;
		                    if((i+1)>=n)
		                    break;
		                }
		                inc[i]=pt;
		                pt++;
		            }
		        }
		         if((i+1)<n){
		            if(ar[i]>ar[i+1]){
		                
		                while(ar[i]>ar[i+1]){
		                    if(inc[i]==0)
		                    inc[i]=pt;
		                    i++;
		                    if((i+1)>=n)
		                    break;
		                }
		                inc[i]=pt;
		                pt++;
		            }
		        }
		    }
            System.out.println(Arrays.toString(inc))
		    while(q>0){
		        int l=sc.hasNextInt()?sc.nextInt():0;
		        int r=sc.hasNextInt()?sc.nextInt():0;
                l--;
                int ans;
                if(inc[l]==inc[l+1])
                ans=inc[r-1]-inc[l]+1;
                else
                ans=inc[r-1]-inc[l];
                if(ans%2==0)
                System.out.println("YES");
                else
                System.out.println("NO");
		        q--;
		    }
	}
}
