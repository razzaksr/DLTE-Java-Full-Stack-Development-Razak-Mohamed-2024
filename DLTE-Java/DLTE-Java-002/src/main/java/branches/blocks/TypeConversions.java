package branches.blocks;

public class TypeConversions {
    public static void main(String[] myInputs) {
        // implicit casting
        char transactionType='C';int modeOfOperation=0;
        modeOfOperation=transactionType;
        System.out.println(modeOfOperation);

        //explicit casting
        double interestRate=7.2;int depositedAmount=24500, maturityAmount=0;
        maturityAmount=(int)(depositedAmount+(depositedAmount*interestRate)/100);
        System.out.println(maturityAmount+" is returns from "+depositedAmount);


        // type parsing
        String myExperience="11.8";

        double experience=Double.parseDouble(myExperience);

        if(experience>=4&&experience<=8){
            System.out.println("Team Lead");
        }
        else if(experience>8&&experience<=12){
            System.out.println("Techincal architect");
        }
        else{
            System.out.println("Project Manager");
        }
    }
}
