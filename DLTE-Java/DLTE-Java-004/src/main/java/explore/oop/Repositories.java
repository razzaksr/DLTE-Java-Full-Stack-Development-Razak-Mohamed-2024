package explore.oop;


// all the methods will be considered as abstract
public interface Repositories {
    SavingsAccount[] myBank=new SavingsAccount[10]; // property
//    public void viewAll();// abstract method

    default void initialize(){
        myBank[0]=new SavingsAccount("Razak Mohamed S",65456789L,12990.4);
        myBank[1]=new SavingsAccount("Arun Rajpurohit",5672893454L,89333.3);
        myBank[2]=new SavingsAccount("Sridhar Moorthi",876545678L,98434544.4);
    }
    default void listAll(){
        for(SavingsAccount each:myBank){
            System.out.println(each);
        }
    }

    static void listFew(){
        for(SavingsAccount each:myBank){
            if(each!=null&&each.getAccountBalance()>=10000)
                System.out.println(each);
        }
    }
}

class NetBanking{
    //public abstract void profile();
    SavingsAccount[] ourBank=new SavingsAccount[10];
}