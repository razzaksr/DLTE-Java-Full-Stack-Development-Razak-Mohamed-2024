package branches.blocks.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class CRUDOverArray {
    public static void main(String[] args) {
        double[] spends={900,12560.4,345.6,9860.6,2100.5,45000.6,910.5};
        //double[] spends=new double[12];

        // CRUD
        // read
        //System.out.println(Arrays.toString(spends));

//        for(double each:spends){
//            System.out.print(each+" ");
//        }
        for(int index=0;index<spends.length;index++){
            System.out.println(spends[index]);
        }
        System.out.println();

        Scanner scanner=new Scanner(System.in);

        double[] income=new double[12];
//        for(double each:income){
//            System.out.println("Enter the current month earnings");
//            each= scanner.nextDouble();
//        }
        for(int index=0;index<income.length;index++){
            System.out.println("Enter the current month earnings");
            income[index]= scanner.nextDouble();
        }

        System.out.println(Arrays.toString(income));
        scanner.close();
    }
}
