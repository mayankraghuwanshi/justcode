import java.util.*;
class main{
    static int solveMine(int x , int y ,int res ,int arr[][]){
        if(x==arr[0].length) return res;
        if(!isValid(x, y, arr)) return res;
        int yArr[] = {-1,0,+1};
        int count=0;
        // System.out.println(x+"\t");
        int cost=arr[x][y];
        for(int i=0;i<3;i++){
            if(isValid(x,y,arr)){
                int rec=solveMine(x+1, y+yArr[i], res+cost, arr);
                count=Math.max(count, rec);
            }
           
        }
        return count;
    }
    static boolean isValid(int x, int y, int arr[][]){
        if(x>=0 && x<arr[0].length && y>=0 && y<arr.length) return true;
        return false;
    }
    public static void main(String[] args) {
        int arr[][] =  {{1, 3, 1, 5},
                        {2, 2, 4, 1},
                        {5, 0, 2, 3},
                        {0, 6, 1, 2}};
        for(int i=0;i<arr.length;i++){
            System.out.println(solveMine(0, 0, i, arr));
        }
    }
}