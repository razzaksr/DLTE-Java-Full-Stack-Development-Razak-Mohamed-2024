package ton.concurrent.features;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException {
        MyProvider provider=new MyProvider();
//        provider.update();
//        provider.report();
        Thread thread1=new Thread(provider,"Prashant");
        Thread thread2=new Thread(provider,"Shreyas");
        Thread thread3=new Thread(provider,"Srikanth");
        Thread thread4=new Thread(provider,"Annamalai");
//        thread4.setPriority(1);
        thread1.start();thread1.join();
        thread2.start();thread2.join();
        thread3.start();thread3.join();
        thread4.start();
//        thread1.run();
//        thread2.run();
//        thread3.run();
//        thread4.run();
    }
}
