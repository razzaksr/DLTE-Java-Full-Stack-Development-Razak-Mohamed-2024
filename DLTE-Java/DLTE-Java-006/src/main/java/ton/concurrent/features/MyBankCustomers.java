package ton.concurrent.features;

public class MyBankCustomers {
    public static void main(String[] args) {
        InsuranceDesk insuranceDesk=new InsuranceDesk();
        Thread threadOne=new Thread(insuranceDesk::listPolicies,"Sanath");
        Thread threadTwo=new Thread(insuranceDesk::newPolicy,"Sinchana");
        Thread threadThree=new Thread(insuranceDesk::listPolicies,"Akshira");
        Thread threadFour=new Thread(insuranceDesk::newPolicy,"Arundhathi");
        threadOne.start();
        threadTwo.start();
        threadThree.start();
        threadFour.start();
    }
}
