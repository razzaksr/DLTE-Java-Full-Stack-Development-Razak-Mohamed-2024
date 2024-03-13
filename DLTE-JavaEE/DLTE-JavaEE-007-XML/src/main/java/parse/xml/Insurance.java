package parse.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "coverage")
public class Insurance {
    private String policyName;
    private int policyPeriod;
    private int premiumAmount;
    private int totalCoverage;

    @Override
    public String toString() {
        return "Insurance{" +
                "policyName='" + policyName + '\'' +
                ", policyPeriod=" + policyPeriod +
                ", premiumAmount=" + premiumAmount +
                ", totalCoverage=" + totalCoverage +
                '}';
    }

    public Insurance() {
    }

    public Insurance(String policyName, int policyPeriod, int premiumAmount, int totalCoverage) {
        this.policyName = policyName;
        this.policyPeriod = policyPeriod;
        this.premiumAmount = premiumAmount;
        this.totalCoverage = totalCoverage;
    }

    @XmlAttribute(name = "title")
    public String getPolicyName() {
        return policyName;
    }

    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

    @XmlElement(name="duration")
    public int getPolicyPeriod() {
        return policyPeriod;
    }

    public void setPolicyPeriod(int policyPeriod) {
        this.policyPeriod = policyPeriod;
    }

    @XmlElement(name = "monthly")
    public int getPremiumAmount() {
        return premiumAmount;
    }

    public void setPremiumAmount(int premiumAmount) {
        this.premiumAmount = premiumAmount;
    }

    @XmlElement(name = "total-value")
    public int getTotalCoverage() {
        return totalCoverage;
    }

    public void setTotalCoverage(int totalCoverage) {
        this.totalCoverage = totalCoverage;
    }
}
