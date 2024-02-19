package branches.blocks;

import java.util.Scanner;

public class Investment {
    public static void main(String[] args) {
        // lumpSum, systematic, rd, fd, ...
        String investmentType="";
        Scanner scanner=new Scanner(System.in);
        System.out.println("------------Welcome to MyBank------------");
        System.out.println("Let us know how you wish to invest our bank ");
        investmentType=scanner.next();
        switch(investmentType){
            case "lumpSum": case "lumpsum": case "LUMPSUM":
                System.out.println("Fixed Deposit with average of 7percent\nMutual funds with high risk");
                break;
            case "systematic": case "rd": case "RD":
                System.out.println("SIP, Recursive Deposit and gold bee's with returns of average 11percent");
                break;
            default:
                System.out.println("No other plans for you");
        }
    }
}
