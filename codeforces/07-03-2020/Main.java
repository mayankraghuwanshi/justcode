import java.util.*;
public class Main{
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = scn.nextInt();
        String str = scn.next();
        char ch[] = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        int res=0;
        for(char c : ch){
            if(c==')'){
                if(stack.isEmpty()){
                    stack.push(c);
                }else{
                    if(stack.peek()=='('){
                        stack.pop();
                    }else {
                        stack.push(c);
                    }
                }
            }
            else if(c=='('){
                if(stack.isEmpty()){
                    stack.push(c);
                }else if(stack.peek()==')'){
                    res+=2;
                    stack.pop();
                }else{
                    stack.push(c);
                }
            }
        }
        if(!stack.isEmpty()){
            System.out.println(-1);
        }else System.out.println(res);
        
    }
}