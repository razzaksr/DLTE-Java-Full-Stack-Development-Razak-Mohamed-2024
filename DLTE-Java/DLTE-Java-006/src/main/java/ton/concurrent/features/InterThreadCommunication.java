package ton.concurrent.features;

import java.util.Scanner;

public class InterThreadCommunication {
    public static void main(String[] args) {
        WithdrawTeller withdrawTeller=new WithdrawTeller();
        DepositTeller depositTeller=new DepositTeller(withdrawTeller);
        Thread thread1=new Thread(withdrawTeller,"Ankitha");
        Thread thread2=new Thread(depositTeller,"Divija");
        thread1.start();thread2.start();
    }
}

class WithdrawTeller implements Runnable{
    int availableToDebit=32900, userDebit=0;
    Scanner scanner=new Scanner(System.in);
    @Override
    public void run() {
        System.out.println("Welcome user "+Thread.currentThread().getName());
        synchronized (scanner){
            System.out.println("Give me the cheque leaf with desire amount ");
            userDebit=scanner.nextInt();
            if(userDebit>availableToDebit){
                try {
                    scanner.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            availableToDebit-=userDebit;
            System.out.println(userDebit+" distributed to the customer");
        }
    }
}
class DepositTeller implements Runnable{
    public DepositTeller(){}
    WithdrawTeller withdraw;
    public DepositTeller(WithdrawTeller teller){
        withdraw=teller;
    }
    int collectionOfDepositAmount=312000, userDeposit=0;
    Scanner scanner=new Scanner(System.in);
    @Override
    public void run() {
        System.out.println("Welcome user "+Thread.currentThread().getName());
        synchronized (withdraw.scanner){
            if(withdraw.availableToDebit<withdraw.userDebit){
                withdraw.availableToDebit+=withdraw.userDebit+20000;
                withdraw.scanner.notify();
            }
            System.out.println("Give me the challan with desire amount ");
            userDeposit=scanner.nextInt();
            collectionOfDepositAmount+=userDeposit;
            System.out.println(userDeposit+" has deposited ");
        }
    }
}