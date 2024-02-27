package org.features.storage.strings;

public class ExecuteCards {
    public static void main(String[] args) throws InterruptedException {
        CardRepository repository=new CardRepository();
        Thread thread1=new Thread(repository,"Ankita");
        Thread thread2=new Thread(repository,"Annapoorna");
        thread1.start();
        thread2.start();
        Thread.sleep(30000);
        System.out.println(repository.stringBuffer.toString());
    }
}
