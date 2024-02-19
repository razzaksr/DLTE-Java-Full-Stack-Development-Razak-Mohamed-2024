package branches.blocks.arrays;

import java.util.Arrays;

public class Filters {
//    static Object[] storage={"Razak Mohamed S",12.5,true,25000};

    public static void main(String[] args) {
        Object[] storage={"Razak Mohamed S",12.5,true,25000};
        Filters.map(storage);
        System.out.println(Filters.search(storage,12.5));
        Filters.findAndReplace(storage,true,'R');
        System.out.println(Arrays.toString(storage));
    }

    public static void findAndReplace(Object[] arr, Object oldValue, Object newValue){
        for(int index=0;index<arr.length;index++){
            if(arr[index].equals(oldValue)){
                arr[index]=newValue;
                System.out.println(newValue+" has replaced "+oldValue+"@ "+index);
                return;
            }
        }
        System.out.println(oldValue+" doesn't found in array to replaced");
    }

    // param with return
    public static int search(Object[] arr,Object object){
        for(int index=0;index<arr.length;index++){
            if(arr[index].equals(object)){
                return index;
            }
        }
        return -1;
    }

    // no param and no return
    public static void map(Object[] arr){
        for(Object each:arr)
            System.out.print(each+" ");
        System.out.println();
    }
}
