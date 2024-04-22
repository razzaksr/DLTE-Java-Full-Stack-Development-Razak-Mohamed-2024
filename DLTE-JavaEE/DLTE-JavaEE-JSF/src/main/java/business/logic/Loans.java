package business.logic;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class Loans {
    private int loanNumber;
    private String loanName;
    private String loanType;
    private String loanDescription;
    private double loanRoi;

    @PostConstruct
    public void initializeMyLoan(){
        loanNumber = 8767890;
        loanName = "Mudhra Vikas";
        loanDescription="MSME developmental loan with 10LPA";
        loanRoi=6.9;
        loanType="Business Loan";
    }

    public int getLoanNumber() {
        return loanNumber;
    }

    public void setLoanNumber(int loanNumber) {
        this.loanNumber = loanNumber;
    }

    public String getLoanName() {
        return loanName;
    }

    public void setLoanName(String loanName) {
        this.loanName = loanName;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public String getLoanDescription() {
        return loanDescription;
    }

    public void setLoanDescription(String loanDescription) {
        this.loanDescription = loanDescription;
    }

    public double getLoanRoi() {
        return loanRoi;
    }

    public void setLoanRoi(double loanRoi) {
        this.loanRoi = loanRoi;
    }

    @Override
    public String toString() {
        return "Loans{" +
                "loanNumber=" + loanNumber +
                ", loanName='" + loanName + '\'' +
                ", loanType='" + loanType + '\'' +
                ", loanDescription='" + loanDescription + '\'' +
                ", loanRoi=" + loanRoi +
                '}';
    }
}