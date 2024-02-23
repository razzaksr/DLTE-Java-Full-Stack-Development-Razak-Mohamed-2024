package ton.concurrent.features;

public class ReferBlocks {
    public void checkEligible(String myName, int score){
        if(score>=750){
            System.out.println(myName+" is eligible for loan");
        }else
            System.out.println(myName+" is  not eligible");
    }
    public static void main(String[] args) {
        ReferBlocks refer=new ReferBlocks();
        // method reference
        Loan loan=refer::checkEligible;
        loan.applyPersonalLoan("Razak MOhmed S",570);
    }
}

interface Loan{
    void applyPersonalLoan(String name, int cibil);
}