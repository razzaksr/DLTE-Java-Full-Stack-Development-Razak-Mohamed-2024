package layer.dao;

public class Bankers {
    private int bankerId;
    private String bankerName;

    public int getBankerId() {
        return bankerId;
    }

    public void setBankerId(int bankerId) {
        this.bankerId = bankerId;
    }

    public String getBankerName() {
        return bankerName;
    }

    public void setBankerName(String bankerName) {
        this.bankerName = bankerName;
    }

    public String getBankerPasscode() {
        return bankerPasscode;
    }

    public void setBankerPasscode(String bankerPasscode) {
        this.bankerPasscode = bankerPasscode;
    }

    @Override
    public String toString() {
        return "Bankers{" +
                "bankerId=" + bankerId +
                ", bankerName='" + bankerName + '\'' +
                ", bankerPasscode='" + bankerPasscode + '\'' +
                '}';
    }

    private String bankerPasscode;
}