package explore.oop.innerclasses;

import java.util.Date;

public class Product {
    public void newLogs(){
        MyRepository.Logs obj=new MyRepository.Logs();
        obj.date=new Date();obj.message="Create operation done";
        MyRepository.logs[0]=obj;
    }
    public static void main(String[] args) {
        System.out.println(MyRepository.logs.length);// 10
        MyRepository.printLogs();
        Product product=new Product();
        product.newLogs();
        MyRepository.printLogs();
    }
}

class MyRepository{
    static class Logs{
        String message;
        Date date;
    }
    static Logs[] logs=new Logs[10];
    public static void printLogs(){
        for (Logs each:logs){
            if(each!=null)
                System.out.println("The date of the log "+each.date+" message is "+each.message);
            else
                System.out.println("Invalid log");
        }
    }
}