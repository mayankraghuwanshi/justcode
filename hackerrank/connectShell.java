import java.util.*;
class main{
    static int solve(int arr[][]){
        boolean visited[][] = new boolean[arr.length][arr[0].length];
        int res=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                res = Math.max(res,solve(i,j,arr,visited));
            }
        }
        return res;
    }
    static boolean isValid(int  y , int x , int arr[][]){
        if(x>=0 && x<arr[0].length && y>=0 && y<arr.length) return true;
        return false;
    }
    static int solve(int y , int x , int arr[][] , boolean visited[][]){
        // System.out.println(y+"\t"+x);
        if(!visited[y][x] && arr[y][x]==1){
            visited[y][x]=true;
            int res=Integer.MIN_VALUE;
            int X[] = {1, 1, 0,-1,-1,-1,0,1};
            int Y[] = {0,-1,-1,-1, 0, 1,1,1};
            for(int i=0;i<8;i++){
                int newX = x+X[i];
                int newY = y+Y[i];
                if(isValid(newY,newX,arr)){
                    res = Math.max(res,1+solve(newY,newX,arr,visited));
                }
            }
            visited[y][x]=false;
            return res;
        }
        return 0;
    }
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        int r = scn.nextInt();
        int c = scn.nextInt();
        int arr[][] = new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                arr[i][j]=scn.nextInt();
            }
        }
        System.out.println(solve(arr));
    }
}