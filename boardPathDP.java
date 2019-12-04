import java.util.*;
class main{

    
    public static int solve(int x,int y,int xf,int yf){
        if(x==xf && y==yf) return 1;
        if(x>xf || y>yf) return 0;
        int count=0;
        count+=solve(x+1,y,xf,yf)+solve(x, y+1, xf, yf);
        return count;
    }
    
    public static long solvePath(int x , int y , int xf , int yf , long dp[][]){
        if(x==xf && y==yf) return 1;
        if(x>xf || y>yf) return 0;
        if(dp[y][x]!=0) return dp[y][x];
        long count=0;
        count+=solvePath(x+1, y, xf, yf, dp)+solvePath(x, y+1, xf, yf, dp);
        dp[y][x]=count;
        return count;
    }

    static int solvePathTB(int x , int y , int tb[][]){
        
        return 1;
    }
    public static void main(String[] args) {
        int x=17;;
        int y=17;
        long t1=System.currentTimeMillis();
        long dp[][] = new long[x+1][y+1];
        // System.out.println(solve(0, 0, x, y));
        System.out.println(solvePath(0, 0, x, y, dp));
        long time = System.currentTimeMillis()-t1;
        System.out.println(time);
        
        
    }
}