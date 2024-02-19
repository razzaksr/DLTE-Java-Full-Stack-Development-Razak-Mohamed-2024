package branches.blocks;

import java.util.Scanner;

public class Flexipay {
    public static void main(String[] args) {
        // initialization
        Integer principleSpent=0,tenure=0;
        Double rateOfInterest=21.25, processing=0.0, repaymentAmount=0.0, emi=0.0;
        Scanner scanner=new Scanner(System.in);
        // required inputs: principle, tenure
        System.out.println("--------------Welcome to Flexi Pay----------------");
        System.out.println("Let us know your spent to convert as EMI");
        principleSpent=scanner.nextInt();
        System.out.println("Let us know tenure ");
        tenure= scanner.nextInt();
        // process
        processing=principleSpent*0.01;
        System.out.println("Processing charges"+ processing +"for converting your spent "+principleSpent);
        processing+=processing*0.180;
        System.out.println("Processing fee included with GST 18percent "+processing);

        // rateOfInterest decision based on tenure
        if(tenure>=3&&tenure<=6){
            rateOfInterest=20.25;
        }
        else if(tenure>6&&tenure<=10){
            rateOfInterest=21.25;
        }
        else if(tenure>10&&tenure<=18){
            rateOfInterest=21.50;
        }
        else if(tenure>18&&tenure<=24){
            rateOfInterest=22.2;
        }
        else{
            rateOfInterest=22.5;
        }

        // interest
        repaymentAmount=principleSpent*rateOfInterest/100;
        System.out.println("Repayment includes the interest amount of "+repaymentAmount+" "+rateOfInterest+" percent");
        repaymentAmount+=principleSpent;
        emi=repaymentAmount/tenure;

        System.out.println("Total repayment of "+repaymentAmount+" along with processing charges "+processing+" with monthly EMI "+emi);
        System.out.println("First EMI includes processing charges total of "+(emi+processing));
        System.out.println("Thanks for choosing Flexipay");

        scanner.close();
    }
}
