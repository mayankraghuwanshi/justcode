import java.util.*;
class main{
    // static boolean type(char arr[][] , boolean isDone[][],int x , int y , String str , String res){
    //     System.out.println(res);
    //     if(res.length()==str.length()){
    //         System.out.println(res);
    //         if(res.equals(res)) return true;
    //         return false;
    //     }
    //     char ch = arr[x][y];
    //     int X[]={-1,0,+1,0};
    //     int Y[]={0,-1,0,+1};
    //     if(ch!='*' && !isDone[x][y]){
    //         isDone[x][y]=true;
    //         for(int i=0;i<4;i++){
    //             int newX=x+X[i];
    //             int newY=y+Y[i];
    //             if(isValid(newX,newY,arr)){
    //                 if(type(arr,isDone,newX,newY,str,res+ch)) return true;
    //             }
    //         }
    //         isDone[x][y]=false;
    //     }
    //     return false;
    // }
    static boolean isValid(int x , int y , char arr[][]){
        if(x>=0 && x<=arr[0].length && y>=0 && y<=arr.length) return true;
        return false;
    }

    static boolean type(char arr[][] , int x , int y , String res , String ans){
        // System.out.println(ans);
        if(res.length()==0) return true;
        char ch1 = res.charAt(0);
        int X[]={0,-1,0,+1,0};
        int Y[]={0,0,-1,0,+1};
        for(int i=0;i<5;i++){
            int newX = x+X[i];
            int newY = y+Y[i];
            if(isValid(newX, newY, arr)){
                char ch2=arr[newX][newY];
                System.out.println("compare "+ch1+"\t"+ch2);
                if(ch1==ch2){
                    return type(arr,newX,newY,res.substring(1),ans+ch1);
                }
            }
        }
        return false;
        
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int r = scn.nextInt();
        int c = scn.nextInt();
        char charr[][] = new char[r][c];
        for(int i=0;i<r;i++){
                charr[i] = scn.next().toCharArray();
        }
        // for(char ch[] : charr){
        //     System.out.println(Arrays.toString(ch));
        // }
        String s = scn.next();
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(charr[i][j]==s.charAt(0)){
                    System.out.println(type(charr, i, j, s,""));
                    break;
                }
            }
        }    
    }
}