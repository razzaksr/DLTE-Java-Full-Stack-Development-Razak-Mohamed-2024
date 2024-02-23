package ton.concurrent.features.maintain;

public class ApplyInsurance {
    public static void main(String[] args) {
        // Runtime runtime=Runtime.getRuntime();
        Insurance insurance=Insurance.getInsurance();// single ton
        insurance.setInsurerName("ICICI Health Insurance");
        System.out.println(insurance.getFeatures().length);
    }
}
