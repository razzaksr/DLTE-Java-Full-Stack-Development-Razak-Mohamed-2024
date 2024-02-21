package explore.oop.executions;

import explore.oop.SavingsAccount;

public class Initiate extends SavingsAccount {
    public Initiate(){
        System.out.println("Initialization is under process");
    }
    public Initiate(String name,Long number, Double balance){
        this.setAccountHolder(name);
        this.setAccountBalance(balance);
        this.setAccountNumber(number);
    }
    public String toString(){
        //System.out.println(this.getClass()+" "+super.getClass());
        System.out.println(super.toString());;
        return "Your KYC details are "+getAccountNumber()+" and "+getAccountBalance()+"\n";
    }
    public static void main(String[] args) {
        Initiate initiate=new Initiate();
        initiate.setAccountHolder("Razak Mohamed S");
        System.out.println(initiate);
//        initiate.showSome();

        Initiate initiate1=new Initiate("Sabari",76567876L,980.4);
        System.out.println(initiate1);
    }
}
