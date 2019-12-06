import java.util.*;
class main{

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n=scn.nextInt();
        int currentEmpSalery[] = new int[n];
        int currentEmpSaleryExp[] = new int[n];
        int m=scn.nextInt();
        int newEmpSalery[] = new int[m];
        int totalAmmount = scn.nextInt();
        for(int i=0;i<n;i++){
            int temp=scn.nextInt();
            currentEmpSaleryExp[i]=scn.nextInt()-temp;
        }
        for(int i=0;i<m;i++){
            newEmpSalery[i] =scn.nextInt();
        }
        Arrays.sort(currentEmpSaleryExp);
        Arrays.sort(newEmpSalery);
        // System.out.println(Arrays.toString(currentEmpSaleryExp));
        // System.out.println(Arrays.toString(newEmpSalery));
        int i=0;
        int j=0;
        int res=0;
        while((i<n || j<m) && totalAmmount>=0){
            // System.out.println(totalAmmount+"\t"+i+"\t"+j+"\t"+res);
            if(i<n && j<m){
                if(currentEmpSaleryExp[i]<newEmpSalery[j]){
                    if(totalAmmount-currentEmpSaleryExp[i]>=0){
                        totalAmmount-=currentEmpSaleryExp[i];
                        i++;
                        res++;
                    }else{
                        System.out.println(res);
                        break;
                    }
                }else{
                    if(totalAmmount-newEmpSalery[j]>=0){
                        totalAmmount-=newEmpSalery[j];
                        j++;
                        res++;
                    }else{
                        System.out.println(res);
                        break;
                    }
                }
            }else if(i<n){
                if(totalAmmount-currentEmpSaleryExp[i]>=0){
                    totalAmmount-=currentEmpSaleryExp[i];
                    i++;
                    res++;
                }else{
                    System.out.println(res);
                    break;
                }
            }else if(j<m){
                if(totalAmmount-newEmpSalery[j]>=0){
                    totalAmmount-=newEmpSalery[j];
                    j++;
                    res++;
                }else{
                    System.out.println(res);
                    break;
                }
            }
        }
    }
}