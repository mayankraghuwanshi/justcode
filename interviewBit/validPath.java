import java.util.*;

class main{
    static void fillPath(boolean visited[][] , int X[] , int Y[] , int R){
        for(int i=0;i<X.length;i++){
            int x=X[i];
            int y=Y[i];
            int r=0;
            while(isValid(y+r,x+r,visited) && r<=R){
                visited[y+r][x+r]=true;
                r++;
            }
        }
    }
    static boolean isValid(int y , int x , boolean visited[][]){
        if(x>=0 && x<visited[0].length && y>=0 && y<visited.length) return true;
        return false;
    }


    static boolean solve(int x , int y, boolean visited[][]){
        if(visited[visited.length-1][visited[0].length-1]) return false;
        if(x==visited[y].length-1 && y==visited.length-1) return true;
        visited[y][x]=true;
        int xcor[] = {1,0,-1,0};
        int ycor[] = {0,1,0,-1};
        boolean res = false;
        for(int i=0;i<4;i++){
            int X = x+xcor[i];
            int Y = y+ycor[i];
            if(isValid(Y,X,visited) && !visited[Y][X]){
                res = res | solve(X,Y,visited);
            }
        }
        visited[y][x]=false;
        return res;
    }
    public static void main(String args[]){
        int x=7;
        int y=91;
        int r=7;
        boolean visited[][] = new boolean[y+1][x+1];
        int xc[] = {1, 7, 1, 7, 1, 5, 1, 6  };
        int yc[] = {25, 4, 74, 14, 90, 58, 37, 4};
        fillPath(visited,xc,yc,r);
        for(boolean i[]:visited){
            System.out.println(Arrays.toString(i));
        }
        System.out.println(solve(0,0,visited));
    }
}