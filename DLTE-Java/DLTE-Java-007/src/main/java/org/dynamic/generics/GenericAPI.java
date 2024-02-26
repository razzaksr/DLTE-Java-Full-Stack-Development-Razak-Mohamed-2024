package org.dynamic.generics;

public class GenericAPI<T> extends MyBankCrudActivity<T>{

    @Override
    public String insertNewRecord(T objects) {
        for(int index=0;index< myObjects.length;index++){
            if(myObjects[index]==null){
                myObjects[index]=objects;
                return objects+" has inserted ";
            }
        }
        return objects+" hasn't inserted";
    }

    @Override
    public T read(int index) {
        if(index>=0&&index< myObjects.length)
            return myObjects[index];
        return null;
    }

    @Override
    public String delete(int index) {
        if(index>=0&&index< myObjects.length&&myObjects[index]!=null){
            T object=myObjects[index];
            myObjects[index]=null;
            return object+" has deleted";
        }
        return null;
    }

    @Override
    public void update(int index, T object) {
        if(index>=0&&index< myObjects.length){
            myObjects[index]=object;
            System.out.println(object+" has updated @ "+index);
        }
        else
            System.out.println(object+" hasn't updated @ "+index);
    }
}
