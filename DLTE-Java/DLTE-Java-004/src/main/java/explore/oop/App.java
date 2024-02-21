package explore.oop;

import lombok.Data;

/**
 * Hello world!
 *
 */

public class App extends NetBanking implements Repositories
{
    public void appendFew(){
        myBank[3]=new SavingsAccount("Rajiya R",2345432345L,999.0);
    }
    public static void main( String[] args )
    {
        SavingsAccount savingsAccount1=new SavingsAccount();
        savingsAccount1.setAccountNumber(6545678945L);

//        Repositories repositories=new Repositories();
        App app=new App();
        app.initialize();
        app.appendFew();
        app.listAll();
//        app.listFew();
        Repositories.listFew();

        app.ourBank=new SavingsAccount[2];
//        app.myBank=new SavingsAccount[2];
    }
}
