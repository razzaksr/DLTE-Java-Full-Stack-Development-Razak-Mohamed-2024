package first;

import java.util.Date;

public class Loan {
    private int loanNumber;
    private int loanAmount;
    private Date loanDate;
    private String loanStatus;
    private String loanBorrower;

    public Loan() {
    }

    public Loan(int loanNumber, int loanAmount, Date loanDate, String loanStatus, String loanBorrower) {
        this.loanNumber = loanNumber;
        this.loanAmount = loanAmount;
        this.loanDate = loanDate;
        this.loanStatus = loanStatus;
        this.loanBorrower = loanBorrower;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "loanNumber=" + loanNumber +
                ", loanAmount=" + loanAmount +
                ", loanDate=" + loanDate +
                ", loanStatus='" + loanStatus + '\'' +
                ", loanBorrower='" + loanBorrower + '\'' +
                '}';
    }

    public int getLoanNumber() {
        return loanNumber;
    }

    public void setLoanNumber(int loanNumber) {
        this.loanNumber = loanNumber;
    }

    public int getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(int loanAmount) {
        this.loanAmount = loanAmount;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    public String getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(String loanStatus) {
        this.loanStatus = loanStatus;
    }

    public String getLoanBorrower() {
        return loanBorrower;
    }

    public void setLoanBorrower(String loanBorrower) {
        this.loanBorrower = loanBorrower;
    }
}
