package org.dynamic.lambda;

public class LinearImplementation {
    static String[] myBankDebitCards={"Rupay","Visa","Master card"};
    public static void main(String[] args) {
        Linear linear=(data -> {
            for(int index=0;index< myBankDebitCards.length;index++){
                if(myBankDebitCards[index].equalsIgnoreCase(data)) {
                    System.out.println(data + " found @ " + index);
                    return;
                }
            }
            System.out.println(data+" wasn't found anywhere");
        });

        linear.linearSearch("Standard");
    }
}
