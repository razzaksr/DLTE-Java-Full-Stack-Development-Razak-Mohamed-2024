package ton.concurrent.features;

public class ExecuteExecutors {
    public static void main(String[] args) {
        MyPolicyBazar bazar=new MyPolicyBazar();
        InsuranceDesk desk=new InsuranceDesk();
        Thread threadOne=new Thread(bazar,"Rakesh");
        Thread threadTwo=new Thread(bazar,"Shreyas");
//        Thread threadTwo=new Thread(desk::newPolicy,"Akshira");
        threadOne.start();
        threadTwo.start();
    }
}
