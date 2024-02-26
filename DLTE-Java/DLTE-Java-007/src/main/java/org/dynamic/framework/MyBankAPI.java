package org.dynamic.framework;

public class MyBankAPI<T> extends MyBank<T>{

    @Override
    public String insertNewRecord(T objects) {
        myObjects.add(objects);
        return objects+" has inserted into records";
    }

    @Override
    public T read(int index) {
        if(index<myObjects.size())
            return myObjects.get(index);
        return null;
    }

    @Override
    public String delete(int index) {
        if(index< myObjects.size())
            return myObjects.remove(index).toString()+" has removed";
        else
            return null;
    }

    @Override
    public void update(int index, T object) {
        if(index< myObjects.size())
            myObjects.set(index,object);
        else
            System.out.println("Updated hasn't done");
    }
}
