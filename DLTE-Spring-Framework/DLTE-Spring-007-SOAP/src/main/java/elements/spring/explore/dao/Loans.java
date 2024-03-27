package elements.spring.explore.dao;

public class Loans {
    private long loanId;
    private double loanPrinciple;
    private String loanBorrower;
    private int loanTenure;
    private double loanInterest;
    private double loanPayable;

    @Override
    public String toString() {
        return "Loans{" +
                "loanId=" + loanId +
                ", loanPrinciple=" + loanPrinciple +
                ", loanBorrower='" + loanBorrower + '\'' +
                ", loanTenure=" + loanTenure +
                ", loanInterest=" + loanInterest +
                ", loanPayable=" + loanPayable +
                '}';
    }

    public Loans() {
    }

    public Loans(long loanId, double loanPrinciple, String loanBorrower, int loanTenure, double loanInterest, double loanPayable) {
        this.loanId = loanId;
        this.loanPrinciple = loanPrinciple;
        this.loanBorrower = loanBorrower;
        this.loanTenure = loanTenure;
        this.loanInterest = loanInterest;
        this.loanPayable = loanPayable;
    }

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
