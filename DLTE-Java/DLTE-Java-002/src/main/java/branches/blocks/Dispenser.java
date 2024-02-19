package branches.blocks;

import java.util.Scanner;

public class Dispenser {
    public static void main(String[] args) {
        String myReceipt="";
        int _500s=25, desiredCash=0, required=0;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Welcome to MyBank ATM\nEnter the desired amount to withdraw ");
        desiredCash= scanner.nextInt();

        if(_500s>0&&desiredCash%500==0){
            required=desiredCash/500;
            if(required<=_500s){
                _500s-=required;
                myReceipt+="500 X "+required;
                desiredCash-=required*500;
            }
            else{
                myReceipt+="500 X "+_500s;
                _500s=0;
                desiredCash-=_500s*500;
            }
        }
        else{
            System.out.println("Insufficient fund in Machine");
        }

        if(desiredCash==0){
            System.out.println(myReceipt);
        }
        else{
            System.out.println("Insufficient fund in Machine");
        }

        scanner.close();
    }
}
