package org.dynamic.framework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

public class IllustrationOfArrayList {
    public static void main(String[] args) {
        ArrayList<Double> myPortfolio=new ArrayList<>();
        Vector<Double> myStocks=new Vector<>();

        myPortfolio.add(78.5);myPortfolio.add(7623.1);myPortfolio.add(9879.4);
        myPortfolio.add(879.1);

        myPortfolio.forEach(System.out::println);
        Collections.sort(myPortfolio);
        myPortfolio.forEach(data-> System.out.println(data));

        myStocks.addAll(myPortfolio);
        myStocks.add(2,555.3);
        myStocks.forEach(System.out::println);

        myPortfolio.set(1,12900.4);
        myPortfolio.add(78.5);myPortfolio.add(879.1);
        System.out.println("My Portfolio:"+myPortfolio);

        Collections.replaceAll(myPortfolio,78.5,187.4);
        System.out.println("My Portfolio:"+myPortfolio);

        System.out.println(myStocks.contains(78.5));

        System.out.println("My Portfolio:"+myPortfolio);
        System.out.println("My Stock"+myStocks);

        myPortfolio.retainAll(myStocks);
        System.out.println("My Portfolio:"+myPortfolio);

        myStocks.removeAll(myPortfolio);
        System.out.println("My Stock"+myStocks);

        System.out.println(Collections.max(myPortfolio));
        System.out.println(Collections.min(myStocks));
        // search
        System.out.println(myStocks.indexOf(78.5));
        System.out.println(myPortfolio.indexOf(78.5));
    }
}
