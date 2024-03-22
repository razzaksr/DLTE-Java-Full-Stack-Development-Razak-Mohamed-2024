package elements.spring.explore.dao;

public class Loans {
    private long loanId;
    private double loanPrinciple;
    private String loanBorrower;
    private int loanTenure;
    private double loanInterest;
    private double loanPayable;

    public long getLoanId() {
        return loanId;
    }

    public void setLoanId(long loanId) {
        this.loanId = loanId;
    }

    public double getLoanPrinciple() {
        return loanPrinciple;
    }

    public void setLoanPrinciple(double loanPrinciple) {
        this.loanPrinciple = loanPrinciple;
    }

    public String getLoanBorrower() {
        return loanBorrower;
    }

    public void setLoanBorrower(String loanBorrower) {
        this.loanBorrower = loanBorrower;
    }

    public int getLoanTenure() {
        return loanTenure;
    }

    public void setLoanTenure(int loanTenure) {
        this.loanTenure = loanTenure;
    }

    public double getLoanInterest() {
        return loanInterest;
    }

    public void setLoanInterest(double loanInterest) {
        this.loanInterest = loanInterest;
    }

    public double getLoanPayable() {
        return loanPayable;
    }

    public void setLoanPayable(double loanPayable) {
        this.loanPayable = loanPayable;
    }
}
