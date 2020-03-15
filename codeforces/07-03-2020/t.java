import java.util.*;

class main{
    public static void main(String args[])
    {

        int t = scn.hasNextInt()?scn.nextInt():0;
        
        while(t-->0)
        {
            int n,W,x,y,max1=0;
            n=scn.hasNextInt()?scn.nextInt():0;
            W=scn.hasNextInt()?scn.nextInt():0;
            x=scn.hasNextInt()?scn.nextInt():0;
            y=scn.hasNextInt()?scn.nextInt():0;
            int wt[] = new int[n];
            int val[] = new int[n];
            for(int i=0;i<n;i++)
            {
                wt[i]=scn.hasNextInt()?scn.nextInt():0;
            }
            for(int i=0;i<n;i++)
            {
                val[i]=scn.hasNextInt()?scn.nextInt():0;
            }
            for(int l=0;l<n;l++)
            {
                for(int k=l+1;k<n;k++)
                {
                    if(val[l]>val[k])
                    {
                        val[l]*=Math.max(x,y);
                        val[k]*=Math.min(x,y);
                    }
                    else
                    {
                        val[l]*=Math.min(x,y);
                        val[k]*=Math.max(x,y);

                    }
                    int i, w; 
                    int K[][] = new int[n+1][n+1];
                    
                    for (i = 0; i <= n; i++) 
                    { 
                        for (w = 0; w <= W; w++) 
                        { 
                            if (i==0 || w==0) 
                                K[i][w] = 0; 
                            else if (wt[i-1] <= w) 
                                    { 
                                        K[i][w] = Math.max(val[i-1] + K[i-1][w-wt[i-1]],  K[i-1][w]);
                                        
                                    } 
                            else
                                    K[i][w] = K[i-1][w]; 
                        } 
                    }
                    if(max1<K[n][W])
                    {
                        max1=K[n][W];
                    }
                    if(val[l]>val[k])
                        {
                            val[l]/=Math.max(x,y);
                            val[k]/=Math.min(x,y);
                        }
                        else
                        {
                            val[l]/=Math.min(x,y);
                            val[k]/=Math.max(x,y);

                        }
                }
            }
        }
        System.out.println(max);
    }
      
}