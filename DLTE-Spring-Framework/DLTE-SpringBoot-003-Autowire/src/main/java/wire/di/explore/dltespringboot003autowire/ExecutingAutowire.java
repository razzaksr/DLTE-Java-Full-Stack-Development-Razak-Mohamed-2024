package wire.di.explore.dltespringboot003autowire;

public class ExecutingAutowire {
    public static void main(String[] args) {
        // constructor base autowire
////        Operations operations=new MyLoanImplementation();
        Operations operations=new MyBondImplementation();
        OperationService operationService=new OperationService(operations);
        System.out.println(operationService.callLiearSearch(2.3));
//        System.out.println(operationService.callLiearSearch(4.5));


        // setter based autowire
        operations=new MyLoanImplementation();
        operationService=new OperationService();
        operationService.setOperations(operations);
        System.out.println(operationService.callLiearSearch(4.5));
    }
}
