package basics.service;

import java.util.Arrays;

// scopes, overloading, execution points

class Traditional {
    static {
        System.out.println("CASA, Funds, Bonds, Loans");
        System.out.println("CLI banking");
        Traditional.main(new Integer[]{12,45,78});
        Traditional.main(new String[]{"TietoEvry","Dlithe"});
    }
    public static void main(Integer[] args) {
        System.out.println("Mobile banking with bio-metric authentication");
        System.out.println(args.length);
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(args));
    }
}

class Facility{
    public static void main(String[] args) {
        System.out.println("ATM, CDM, Passbook entry");
    }
}

class Device{
    public static void main(String[] args) {
        System.out.println("Internet banking and Wallets");
    }
}