package explore.oop;

public class IluustrateClone{
    public static void main(String[] args) throws CloneNotSupportedException {
        SavingsAccount account1=new SavingsAccount("Razak",345432345L,200.9);
        SavingsAccount account2=account1;
        System.out.println(account2);
        account1.setAccountBalance(account1.getAccountBalance()+100);
        System.out.println(account1);
        System.out.println(account2);
    }
}
