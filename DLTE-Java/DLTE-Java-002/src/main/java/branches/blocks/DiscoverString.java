package branches.blocks;

public class DiscoverString {
    public static void main(String[] args) {
        String myPortfolio="Gold, JSW";// literal
        String myStocks=new String("Wipro, Reliance, HP, Infosys");// non literal

        // storage logic: CRUD
        myStocks=myStocks.concat(", Microsoft");//myStocks.concat("Microsoft");// immutable
        System.out.println(myStocks);

        // read
        System.out.println(myPortfolio.charAt(0));// G
        System.out.println(myStocks.substring(10,14));

        // trim
        // contains
        System.out.println(myStocks.contains("Reliance"));

        // update
        myStocks=myStocks.replace("HP", "Bharat Petroleum");
        System.out.println(myStocks);
    }
}
