import java.util.Scanner;

class main{
    static int solve(int x , int y , int maze[][] ,int moves){
        if(maze[y][x]==0  && moves==0) {
            maze[x][y]=1;
            return 1;
        }
        int res=0;
        if(moves>0){
            int X[] = { -2, -1, 1, 2, -2, -1, 1, 2 };
            int Y[] = { -1, -2, -2, -1, 1, 2, 2, 1 };
            for(int i=0;i<8;i++){
                int newX = x+X[i];
                int newY = y+Y[i];
                if(isValid(newX, newY, maze)){
                    // maze[newY][newX]=-1;
                    res+=solve(newX,newY, maze ,moves-1);
                    // maze[newY][newX]=0;
                }
            }
        }
       return res;
      }
    
    static boolean isValid(int x , int y ,int maze[][]){
        if(x<maze[0].length && x>=0 && y>=0 && y<maze.length) return true;
        return false;
    }
    public static void main(String args[]){
        int maze[][] = new int[10][10];
        Scanner scn = new Scanner(System.in);
        System.out.println(solve(scn.nextInt(), scn.nextInt() , maze, scn.nextInt()));


    }
}