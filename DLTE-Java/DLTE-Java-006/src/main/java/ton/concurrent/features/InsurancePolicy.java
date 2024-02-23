package ton.concurrent.features;

import java.util.Arrays;

public class InsurancePolicy {
    private String policyName;
    private String policyFeatures[];
    private int period;
    private int price;

    public InsurancePolicy() {
    }

    public InsurancePolicy(String policyName, String[] policyFeatures, int period, int price) {
        this.policyName = policyName;
        this.policyFeatures = policyFeatures;
        this.period = period;
        this.price = price;
    }

    @Override
    public String toString() {
        return "InsurancePolicy{" +
                "policyName='" + policyName + '\'' +
                ", policyFeatures=" + Arrays.toString(policyFeatures) +
                ", period=" + period +
                ", price=" + price +
                '}';
    }

    public String getPolicyName() {
        return policyName;
    }

    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

    public String[] getPolicyFeatures() {
        return policyFeatures;
    }

    public void setPolicyFeatures(String[] policyFeatures) {
        this.policyFeatures = policyFeatures;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}