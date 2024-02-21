package explore.oop.executions;

import explore.oop.CrudRepository;
import explore.oop.SavingsAccount;

import java.util.Arrays;

public class MyCrudExecution implements CrudRepository {
    public static void main(String[] args) {
        MyCrudExecution myCrudExecution=new MyCrudExecution();
//        myCrudExecution.view();
//        myCrudExecution.view("R");
        System.out.println(Arrays.toString(myCrudExecution.arr));
        myCrudExecution.annualCharges();
//        myCrudExecution.view();
        System.out.println(Arrays.toString(myCrudExecution.arr));

    }

    int[] arr={12,56,43,67};

    @Override
    public void annualCharges() {
//        double temp=0;
//        int index=0;
//        while(index<myBank.length){
//            temp=myBank[index].getAccountBalance();
//            myBank[index].setAccountBalance(temp-300);
//            index++;
//        }
        // this happens because of dependency between each and mybank current object
        for(SavingsAccount each:myBank){
            each.setAccountBalance(each.getAccountBalance()-300);
        }
        for(int each:arr){
            each+=2;
        }
    }
}
