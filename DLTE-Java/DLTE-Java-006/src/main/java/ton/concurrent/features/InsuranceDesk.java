package ton.concurrent.features;

import java.util.Scanner;

public class InsuranceDesk implements Runnable, InsuranceDeskFunctionality{
    Scanner scanner=new Scanner(System.in);
    InsurancePolicy[] myBankInsurance;
    public InsuranceDesk(){
        myBankInsurance=new InsurancePolicy[4];
    }
    public InsuranceDesk(int limit){
        myBankInsurance=new InsurancePolicy[limit];
    }
    @Override
    public void run() {

    }

    @Override
    synchronized public void newPolicy() {
        System.out.println("Welcome to my bank to take your policy "+Thread.currentThread().getName());
        InsurancePolicy policy=new InsurancePolicy();
        System.out.println("Name the policy ");
        policy.setPolicyName(scanner.next());
        System.out.println("Mention the policy period");
        policy.setPeriod(scanner.nextInt());
        System.out.println("Mention the policy price");
        policy.setPrice(scanner.nextInt());
        System.out.println("Mention number of features");
        int numberOfFeature= scanner.nextInt();
        String[] localFeatures=new String[numberOfFeature];
        for(int index=0;index<numberOfFeature;index++){
            localFeatures[index]= scanner.next();
        }
        policy.setPolicyFeatures(localFeatures);
        for(int index=0;index<myBankInsurance.length;index++){
            if(myBankInsurance[index]==null) {
                myBankInsurance[index]=policy;
                System.out.println(policy.getPolicyName()+" has added with MyBank");
                return;
            }
        }
        System.out.println("Maximum number of policies limit achieved");
    }

    @Override
    public void listPolicies() {
        System.out.println("View our policy catalog "+Thread.currentThread().getName());
        for(InsurancePolicy each:myBankInsurance){
            System.out.println(each);
        }
    }
}
