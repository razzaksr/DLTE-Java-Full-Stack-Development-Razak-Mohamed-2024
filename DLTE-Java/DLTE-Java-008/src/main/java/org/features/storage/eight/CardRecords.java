package org.features.storage.eight;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CardRecords implements Runnable{
    Lock lock=new ReentrantLock();
    private ArrayList<DebitCard> cardArrayList=new ArrayList<>();
    private Scanner scanner=new Scanner(System.in);

    public void viewAll(){
        cardArrayList.forEach(System.out::println);
    }

    public void addNewCard(DebitCard card){
        cardArrayList.add(card);
        System.out.println(card+" has inserted into records");
    }

    public String removeExists(long cardNumber){
        boolean acknowledge = cardArrayList.removeIf(each->each.getDebitCardNumber().equals(cardNumber));
        return acknowledge?cardNumber+" has deleted":cardNumber+" hasn't deleted";
    }

    @Override
    public void run() {
        lock.lock();
        System.out.println("Welcome "+Thread.currentThread().getName());
        System.out.println("Tell us what you wish to perform\n1.insert\n2.delete");
        String option= scanner.next();
        switch (option){
            case "insert":
                DebitCard debitCard=new DebitCard();
                System.out.println("Enter the card number");
                debitCard.setDebitCardNumber(scanner.nextLong());
                System.out.println("Enter the card expiry");
                debitCard.setDebitCardExpiry(new Date(scanner.next()));
                System.out.println("enter the cvv number");
                debitCard.setDebitCardCvv(scanner.nextInt());
                System.out.println("entre the pin");
                debitCard.setDebitCardPin(scanner.nextInt());
                addNewCard(debitCard);
                break;
            case "delete":
                System.out.println("Entre the card number to delete");
                System.out.println(removeExists(scanner.nextLong()));
                break;
        }
        viewAll();
        lock.unlock();
    }
}
