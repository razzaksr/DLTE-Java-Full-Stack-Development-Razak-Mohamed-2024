package branches.blocks;

public class CommandLineArgument {
    public static void main(String[] myInputs) {
        double currentRate=0;
        for(int index=0;index<myInputs.length;index++){
            currentRate=Double.parseDouble(myInputs[index]);
            System.out.println(currentRate+" is match with following product");
            if(currentRate>=2&&currentRate<=4){
                System.out.println("Savings bank account");
            }
            else if(currentRate>4&&currentRate<=8){
                System.out.println("Fixed Deposit");
            }
            else if(currentRate>8&&currentRate<=10){
                System.out.println("RD");
            }
            else if(currentRate>10&&currentRate<=12){
                System.out.println("SIP");
            }
            else{
                System.out.println("High risk mutual fund");
            }
        }
    }
}
