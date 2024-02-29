package app.mybank.entity;

import java.util.Comparator;

public class TransactionComparator implements Comparator<Transaction> {

    private String propertyBy;
    private String orderBy;

    public TransactionComparator(String userWish){
        String[] current=userWish.split(",");
        propertyBy=current[0];
        orderBy=current[1];
    }

    @Override
    public int compare(Transaction o1, Transaction o2) {
        int order=0;
        switch (propertyBy){
            case "id": case "Id":
                order=o1.getTransactionId().compareTo(o2.getTransactionId());
                break;
            case "date": case "Date":
                order=o1.getTransactionDate().compareTo(o2.getTransactionDate());
                break;
            case "by": case "By":
                order=o1.getTransactionDoneBy().compareTo(o2.getTransactionDoneBy());
                break;
            case "amount": case "Amount":
                order=o1.getTransactionAmount().compareTo(o2.getTransactionAmount());
                break;
            case "merchant": case "Merchant":
                order=o1.getMerchant().compareTo(o2.getMerchant());
                break;
        }
        return orderBy.equals("ascending")?order:-order;
    }
}
