package ton.concurrent.features;

import java.util.Arrays;
import java.util.Scanner;

public class MyPolicyBazar implements MyEliteCustomers, Runnable {
    InsurancePolicy[] available={
            new InsurancePolicy("Star Comprehensive",new String[]{"NoClaimBonus","PostTreatmentClaim","Thyroid"},3,28000),
            new InsurancePolicy("LIC Plus",new String[]{"PostTreatmentClaim","Dialysis"},1,12000),
            new InsurancePolicy("Jeevan Anand",new String[]{"PrivateRoom","Pre-admission-treatment","Thyroid"},2,56000),
            new InsurancePolicy("Star Elite",new String[]{"Post-Surgary","Sugary","Accidental"},1,30000),
            new InsurancePolicy("Elite Group",new String[]{"Scans","Pharmacy"},3,8000),
    };

    @Override
    public void filter(String feature) {
        for(InsurancePolicy each:available){
            if(Arrays.toString(each.getPolicyFeatures()).contains(feature))
                System.out.println(each);
        }
    }

    @Override
    public InsurancePolicy[] filter(int price) {
        InsurancePolicy[] collected=new InsurancePolicy[available.length];
        int index=0;
        for(InsurancePolicy each:available){
            if(each.getPrice()<=price){
                collected[index]=each;
                index++;
            }
        }
        return collected;
    }

    Scanner scanner=new Scanner(System.in);
    @Override
    synchronized public void run() {
        System.out.println("Welcome to MyEliteBank Insurance Section");
        System.out.println("Let us know based on you need to enquire");
        String basedOn=scanner.next();
        switch (basedOn){
            case "feature": case "FEATURE":
                System.out.println("Enter the required feature");
                String feature=scanner.next();
                filter(feature);
                break;
            case "price": case "PRICE": case "cost":
                System.out.println("Enter the price based on filter");
                int price=scanner.nextInt();
                if(price<=0)
                    Thread.currentThread().stop();
                System.out.println(Arrays.toString(filter(price)));
                break;
            default:break;
        }
    }
}
