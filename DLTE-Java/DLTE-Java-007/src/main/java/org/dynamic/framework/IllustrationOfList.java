package org.dynamic.framework;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


// add, addAll, add(pos,obj)
// get(index)
// remove(pos), remove(obj)
// retainsAll, removeAll
// forEach
// stream
// contains>> true
// set(pos,obj)
public class IllustrationOfList {
    public static void main(String[] args) {
//        ArrayList arrayList=new ArrayList();// generics
        ArrayList arrayList=new ArrayList(1);// generics
        arrayList.add(12);arrayList.add("Razak Mohamed s");
        System.out.println(arrayList);

        ArrayList<String> stringArrayList=new ArrayList<>();
        //stringArrayList.add(12);

        String deposits1="Fixed";String deposits2="RD";
        stringArrayList = (ArrayList<String>) Stream.of(deposits1,deposits2).collect(Collectors.toList());
        System.out.println(stringArrayList);

        Vector<String> stringVector=new Vector<>(stringArrayList);
//        for(String each:stringVector){
//            System.out.println(each);
//        }
//        Iterator<String> stringIterator=stringVector.iterator();
//        while(stringIterator.hasNext()){
//            System.out.println(stringIterator.next());
//        }

//        stringArrayList.forEach(System.out::println);
//        stringVector.forEach(item-> System.out.println(item));
//        for(int index=0;index<stringArrayList.size();index++){
//            System.out.println(stringArrayList.get(index));
//        }

        List<Integer> integerList=new ArrayList<>();
        integerList.add(12);integerList.add(89);
        //integerList.addAll();

    }
}
