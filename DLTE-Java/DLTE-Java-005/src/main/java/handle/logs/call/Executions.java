package handle.logs.call;

import handle.logs.Beneficiaries;
import handle.logs.MySpends;

// since Beneficiaries are final it cannot inherited
//public class Executions extends Beneficiaries {
public class Executions extends MySpends {
    // final methods cannot be override
//    public void filter(String phrase){
//
//    }
    public static void main(String[] args) {
        Beneficiaries beneficiaries=new Beneficiaries();
        System.out.println(beneficiaries.getMyBeneficiaries().length);
        Executions executions=new Executions();
        executions.filter("E");
    }
}
