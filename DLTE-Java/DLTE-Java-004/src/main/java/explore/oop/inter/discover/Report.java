package explore.oop.inter.discover;

import explore.oop.SavingsAccount;

public class Report implements BasicProcedings{
    static SavingsAccount[] myBank=new SavingsAccount[4];
    public static void main(String[] args) {
        myBank[0]=new SavingsAccount("Razak Mohamed S",65456789L,12990.4);
        myBank[1]=new SavingsAccount("Arun Rajpurohit",5672893454L,89333.3);
        myBank[2]=new SavingsAccount("Sridhar Moorthi",876545678L,98434544.4);
        Report report=new Report();
        //SavingsAccount account=new SavingsAccount("",876545678L,1212.3);
        Integer account=90;
        report.insert(account);
        SavingsAccount account2=new SavingsAccount("Rajiya R",876545678L,1212.3);
        report.insert(account2);
        report.list();
    }

    @Override
    public void insert(Object object) {
        if(object.getClass().equals(SavingsAccount.class)){
            for(int index=0;index<myBank.length;index++){
                if(myBank[index]==null){
                    myBank[index]=(SavingsAccount) object;
                    System.out.println(myBank[index]);
                    return;
                }
            }
        }
        else{
            System.out.println("Invalid savings account");
        }
    }

    @Override
    public Object read(int position) {
        return null;
    }

    @Override
    public void list() {
        for(SavingsAccount each:myBank)
            System.out.println(each);
    }
}
