import java.util.*;

 class pair{
        int f;
        int s;
        pair(int f,int s){
            this.f=f;
            this.s=s;
        }
    }
class main{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int tc=scn.nextInt();
        StringBuilder sb = new StringBuilder();
        while(tc-->0){
            int n=scn.hasNextInt()?scn.nextInt():0;
            int w=scn.hasNextInt()?scn.nextInt():0;
            int x=scn.hasNextInt()?scn.nextInt():0;
            int y = scn.hasNextInt()?scn.nextInt():0;
            int max=Math.max(x,y);
            int min=Math.min(x,y);
            pair p[] = new pair[n];
            int a[]=new int[n];
            for(int i=0;i<n;++i){
                a[i]=scn.hasNextInt()?scn.nextInt():0;
            }
            for(int i=0;i<n;++i){
                int b=scn.hasNextInt()?scn.nextInt():0;
                p[i]=new pair(a[i],b);
            }
        Arrays.sort(p,new Comparator<pair>(){
            @Override
            public int compare(pair p1,pair p2){
                if(p1.s==p2.s){
                    return p1.f-p2.f;
                }
                return p2.s-p1.s;
            }
        });
        long ans=0;
        for(pair item : p){
            if((w-item.f)>=0){
                long temp=1;
                long temp1=1;
                if(max>0){
                    temp=max;
                    max=0;
                }
                else if(min>0){
                    temp1=min;
                    min=0;
                }
                ans=ans+(long)(item.s*temp*temp1);
                w=w-item.f;
            }
            if(w==0){
                break;
            }
        }
        sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}