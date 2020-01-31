import java.util.*;
class main{
    static String unit[] = {"","one","two","three","four","five","six","seven","eight","nine","ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
    static String tenth[] = {"","ten","twenty","thirty","fourty","fifty","sixty","seventy","eighty","ninety"};
    static String numToWord(int n){
        if(n==0) return "";
        else if(n>0 && n<20){
            return unit[n];
        }else if(n<100){
            return tenth[n/10]+" "+unit[n%10];
        }else if(n<1000){
            return unit[n/100]+" hundred"+" "+numToWord(n%100);
        }else if(n<10000){
            //1001
            return unit[n/1000]+" thousand"+" "+numToWord(n%1000);
        }else if(n<100000){
            //21,001
            return numToWord(n/1000)+" thousand"+" "+numToWord(n%1000); 
        }
        return "";
    } 
    public static void main(String args[]){
        System.out.println(numToWord(213));

    }
}