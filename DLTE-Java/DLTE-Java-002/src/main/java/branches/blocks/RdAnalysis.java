package branches.blocks;

import java.util.Scanner;

public class RdAnalysis {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int month=12, amount=0, firstLeastMinimal=Integer.MAX_VALUE,secondLeastMinimal=Integer.MAX_VALUE;// loop control: initialization

        while(month>0){
            System.out.println("Pay your monthly RD ");
            amount= scanner.nextInt();
            if(amount<firstLeastMinimal){
                secondLeastMinimal=firstLeastMinimal;
                firstLeastMinimal=amount;
            }
            else if(amount<secondLeastMinimal&&amount!=firstLeastMinimal){
                secondLeastMinimal=amount;
            }
            month--;
        }

        System.out.println(firstLeastMinimal+" and "+secondLeastMinimal+" are the least investments made in RD");

        scanner.close();
    }
}
