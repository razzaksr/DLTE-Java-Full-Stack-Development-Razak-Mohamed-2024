package org.dynamic.framework;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class MyBank<T> {
    ArrayList<T> myObjects=new ArrayList<>();
    public abstract String insertNewRecord(T objects);
    public void viewAll(){
        myObjects.forEach(System.out::println);
    }
    // generic method with return type
    public abstract T read(int index);
    public abstract String delete(int index);
    public abstract void update(int index,T object);
}
