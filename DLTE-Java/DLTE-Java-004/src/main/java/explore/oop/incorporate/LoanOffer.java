package explore.oop.incorporate;

public class LoanOffer extends TransactionData{
    void view(){
        for(Transaction each:transactions){
            System.out.println(each);
        }
    }

    public void personalLoan(Customer customer){
        int count=0;
        for(int index=0;index < transactions.length;index++){
            if(transactions[index].getSender()==customer&&transactions[index].getAmount()<=10000){
                count++;
            }
        }
        if(count>=2)
            System.out.println(customer.getCustomerName()+" eligible for personal loan");
        else
            System.out.println(customer.getCustomerName()+" not eligible to PL");
    }

    public static void main(String[] args) {
        LoanOffer loanOffer=new LoanOffer();
        loanOffer.view();
        loanOffer.personalLoan(loanOffer.customer1);
        loanOffer.personalLoan(loanOffer.customer2);
        loanOffer.personalLoan(loanOffer.customer3);
        loanOffer.personalLoan(loanOffer.customer4);
    }
}

class TransactionData{
    public Transaction[] transactions=new Transaction[10];
    Customer customer1=new Customer("Razak Mohamed S",8767845,1199);
    Customer customer2=new Customer("Manoj Kumar M",5673456,1223);
    Customer customer3=new Customer("Annamalai S",9873455,1191);
    Customer customer4=new Customer("Akash",87845555,5612);

    public TransactionData(){
        transactions[0]=new Transaction(customer2,200,customer1,"Credit");
        transactions[1]=new Transaction(customer4,12000,customer2,"Debit");
        transactions[2]=new Transaction(customer1,89000,customer3,"Credit");
        transactions[3]=new Transaction(customer4,1200,customer1,"Credit");
        transactions[4]=new Transaction(customer2,2000,customer3,"Debit");
        transactions[5]=new Transaction(customer1,1892,customer3,"Debit");
        transactions[6]=new Transaction(customer3,9845,customer4,"Credit");
        transactions[7]=new Transaction(customer4,13345,customer2,"Debit");
        transactions[8]=new Transaction(customer2,98564,customer1,"Credit");
        transactions[9]=new Transaction(customer1,3542,customer3,"Debit");
    }
}
