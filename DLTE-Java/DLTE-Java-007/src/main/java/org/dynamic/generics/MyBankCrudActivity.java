package org.dynamic.generics;

// Generic abstract class

import java.util.Arrays;

public abstract class MyBankCrudActivity<T> {
    // generic array of objects
    T[] myObjects;
    // generic method with argument
    public abstract String insertNewRecord(T objects);
    public void viewAll(){
        System.out.println(Arrays.toString(myObjects));
    }
    // generic method with return type
    public abstract T read(int index);
    public abstract String delete(int index);
    public abstract void update(int index,T object);
}
