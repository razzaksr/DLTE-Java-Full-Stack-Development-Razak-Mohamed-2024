package explore.oop;

public interface CrudRepository {
    int numberOfLeanBalance=0;
    static SavingsAccount[] myBank={
            new SavingsAccount("Razak Mohamed S",65456789L,12990.4),
            new SavingsAccount("Arun Rajpurohit",5672893454L,89333.3),
            new SavingsAccount("Sridhar Moorthi",876545678L,98434544.4)
    };

    default void view(){
        for(SavingsAccount each:myBank){
            System.out.println(each);
        }
    }

    default void view(String phrase){
        for (SavingsAccount each:myBank){
            if(each.getAccountHolder().contains(phrase))
                System.out.println(each);
        }
    }

    void annualCharges();

}
