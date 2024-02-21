package explore.oop;

public class SavingsAccount {
    public SavingsAccount(){
        System.out.println("Initialize KYC to get account details");
    }

    public SavingsAccount(String accountHolder, Long accountNumber, Double accountBalance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
    }

    public String toString(){
        return "SB account details "+getAccountHolder()+" and "+getAccountNumber()+" "+getAccountBalance()+"\n";
    }
    private String accountHolder;
    private Long accountNumber;
    private Double accountBalance;

    protected String getAccountHolder() {
        return accountHolder;
    }

    protected void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    protected Long getAccountNumber() {
        return accountNumber;
    }

    protected void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getAccountBalance() {
        return accountBalance;
    }

    void showSome(){
        System.out.println("Simple default method");
    }

    public void setAccountBalance(Double accountBalance) {
        this.accountBalance = accountBalance;
    }
}
