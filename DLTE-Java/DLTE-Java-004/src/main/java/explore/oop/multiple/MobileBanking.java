package explore.oop.multiple;

public class MobileBanking implements TransactionOperation,TypicalOperations{
    public static void main(String[] args) {
        MobileBanking mobileBanking=new MobileBanking();
        mobileBanking.validate();
    }

    @Override
    public void validate() {

    }

    @Override
    public void buildPortfolio() {

    }
}
