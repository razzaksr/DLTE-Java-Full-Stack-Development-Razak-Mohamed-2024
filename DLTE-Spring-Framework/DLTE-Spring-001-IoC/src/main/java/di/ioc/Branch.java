package di.ioc;

public class Branch {
    private String branchName;
    private String ifsCode;
    private int branchId;
    private String bankName;
    private long branchContact;

    @Override
    public String toString() {
        return "Branch{" +
                "branchName='" + branchName + '\'' +
                ", ifsCode='" + ifsCode + '\'' +
                ", branchId='" + branchId + '\'' +
                ", bankName='" + bankName + '\'' +
                ", branchContact=" + branchContact +
                '}';
    }

    public Branch() {
    }

    public Branch(String branchName, String ifsCode, int branchId, String bankName, long branchContact) {
        this.branchName = branchName;
        this.ifsCode = ifsCode;
        this.branchId = branchId;
        this.bankName = bankName;
        this.branchContact = branchContact;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getIfsCode() {
        return ifsCode;
    }

    public void setIfsCode(String ifsCode) {
        this.ifsCode = ifsCode;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public long getBranchContact() {
        return branchContact;
    }

    public void setBranchContact(long branchContact) {
        this.branchContact = branchContact;
    }
}
