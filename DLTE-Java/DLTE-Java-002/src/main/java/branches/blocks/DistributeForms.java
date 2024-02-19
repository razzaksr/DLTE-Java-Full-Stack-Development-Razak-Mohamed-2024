package branches.blocks;

import java.util.Scanner;

public class DistributeForms {
    public static void main(String[] args) {
        // required initialization
        int numberOfForms=20, required=0; double timing=10.00;
        Scanner scanner=new Scanner(System.in);

        // process
        for(;numberOfForms>0&&timing<=10.40;timing+=0.01){
            System.out.println("Let us know how many KYC required");
            required= scanner.nextInt();// 5
            if(numberOfForms>=required){
                numberOfForms-=required;// iterative : non linear and conditional
                System.out.println(required+" number of KYC issued ");
            }
            else{
                System.out.println("Only "+numberOfForms+ "KYC available");
            }
        }

        System.out.println("Number of KYC at end of the day is "+numberOfForms);

    }
}
