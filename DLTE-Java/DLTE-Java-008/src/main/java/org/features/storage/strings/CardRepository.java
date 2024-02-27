package org.features.storage.strings;

import org.features.storage.eight.DebitCard;

import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CardRepository implements Runnable{
    ResourceBundle resourceBundle=ResourceBundle.getBundle("application");
    StringBuffer stringBuffer=new StringBuffer("Card Activities\n");
    Lock lock=new ReentrantLock();
    private ArrayList<DebitCard> cardArrayList=new ArrayList<>();
    private Scanner scanner=new Scanner(System.in);

    public void viewAll(){
        cardArrayList.forEach(System.out::println);
    }

    public String addNewCard(DebitCard card){
        cardArrayList.add(card);
        return card+resourceBundle.getString("card.insert");
//        System.out.println(card+" has inserted into records");
    }

    public String removeExists(long cardNumber){
        boolean acknowledge = cardArrayList.removeIf(each->each.getDebitCardNumber().equals(cardNumber));
        return acknowledge?cardNumber+resourceBundle.getString("card.isDelete"):cardNumber+resourceBundle.getString("card.isNotDelete");
    }

    @Override
    public void run() {
        lock.lock();
        System.out.println("Welcome "+Thread.currentThread().getName());
        System.out.println(resourceBundle.getString("card.menu"));
        String option= scanner.next();
        switch (option){
            case "insert":
                DebitCard debitCard=new DebitCard();
                System.out.println(resourceBundle.getString("card.number"));
                debitCard.setDebitCardNumber(scanner.nextLong());
                System.out.println(resourceBundle.getString("card.expiry"));
                debitCard.setDebitCardExpiry(new Date(scanner.next()));
                System.out.println(resourceBundle.getString("card.cvv"));
                debitCard.setDebitCardCvv(scanner.nextInt());
                System.out.println(resourceBundle.getString("card.pin"));
                debitCard.setDebitCardPin(scanner.nextInt());
                stringBuffer.append(addNewCard(debitCard)+"\n");
                break;
            case "delete":
                System.out.println(resourceBundle.getString("card.delete"));
                stringBuffer.append(removeExists(scanner.nextLong())+"\n");
                break;
        }
        viewAll();
        lock.unlock();
    }
}
