package ton.concurrent.features.maintain;

public class Insurance {
    private Insurance(){}
    private static Insurance insurance=new Insurance();

    public static Insurance getInsurance() {
        return insurance;
    }

    private String insurerName;
    private String[] features={"No Claim bonus","Private room","Pre Claim","Post Claim","Lab tests","Pharmacy"};

    public String getInsurerName() {
        return insurerName;
    }

    public void setInsurerName(String insurerName) {
        this.insurerName = insurerName;
    }

    public String[] getFeatures() {
        return features;
    }

    public void setFeatures(String[] features) {
        this.features = features;
    }
}
