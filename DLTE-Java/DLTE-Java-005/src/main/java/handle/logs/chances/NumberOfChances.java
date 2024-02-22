package handle.logs.chances;

import java.util.Scanner;

public class NumberOfChances {
    static Scanner scanner=new Scanner(System.in);
    static Integer tenure=0;
    public static double findEmi(int repayment){
        try{
            System.out.println("Let us know tenure ");
            tenure= scanner.nextInt();
            return repayment/tenure;
        }
        catch (ArithmeticException arithException){
            System.out.println(arithException);
            return findEmi(repayment);
        }
    }
    public static void main(String[] args) {
        Integer principleSpent=0;
        double rateOfInterest=21.25, processing=0.0, repaymentAmount=0.0, emi=0.0;

        // required inputs: principle, tenure
        System.out.println("--------------Welcome to Flexi Pay----------------");
        System.out.println("Let us know your spent to convert as EMI");
        principleSpent=scanner.nextInt();
        // process
        processing=principleSpent*0.01;
        System.out.println("Processing charges"+ processing +"for converting your spent "+principleSpent);
        processing+=processing*0.180;
        System.out.println("Processing fee included with GST 18percent "+processing);

        // interest
        repaymentAmount=principleSpent*rateOfInterest/100;
        System.out.println("Repayment includes the interest amount of "+repaymentAmount+" "+rateOfInterest+" percent");
        repaymentAmount+=principleSpent;

        emi=NumberOfChances.findEmi((int)repaymentAmount);

        System.out.println("Total repayment of "+repaymentAmount+" along with processing charges "+processing+" with monthly EMI "+emi);
        System.out.println("First EMI includes processing charges total of "+(emi+processing));
        System.out.println("Thanks for choosing Flexipay");

        scanner.close();
    }
}
