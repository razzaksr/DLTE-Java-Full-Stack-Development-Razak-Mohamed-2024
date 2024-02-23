package ton.concurrent.features;

import java.util.Arrays;

//public class MyProvider extends Thread{
public class MyProvider implements Runnable{
    double[][] deposits={
            {1200.5,56000.75,8045.9},
            {93842.5,9458.23,9845.1},
            {48566.5,932423.48},
    };

    public void update(){
        for(int row=0;row<deposits.length;row++){
            for(int column=0;column<deposits[row].length;column++){
                if(deposits[row][column]>2000&&deposits[row][column]<=10000){
                    deposits[row][column]+=deposits[row][column]*0.07;
                }
            }
        }
    }
    public void report(){
        System.out.println(Thread.currentThread().getName()+" has called the report");
        for(double[] row:deposits){
            System.out.println(Arrays.toString(row));
        }
    }

//    synchronized public void run(){
    public void run(){
        System.out.println(Thread.currentThread().getId()+"\n"+Thread.currentThread().getName());
        update();
        report();
//        synchronized (this){
//            report();
//        }
    }
}
