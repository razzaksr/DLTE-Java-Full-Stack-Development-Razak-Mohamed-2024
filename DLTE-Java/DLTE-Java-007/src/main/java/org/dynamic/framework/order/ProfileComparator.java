package org.dynamic.framework.order;

import org.dynamic.generics.Profile;

import java.util.Comparator;

public class ProfileComparator implements Comparator<Profile> {

    private String byAttribute;
    private String orderBy;

    public ProfileComparator(String userOrder){
        String[] atThis = userOrder.split(":");// username:ascending
        byAttribute=atThis[0];
        orderBy=atThis[1];
    }

    @Override
    public int compare(Profile o1, Profile o2) {
        int returnedOrder=0;
        switch(byAttribute){
            case "username": case "USERNAME": case "Username":
                returnedOrder=o1.getUsername().compareTo(o2.getUsername());break;
            case "address": case "ADDRESS": case "Address":
                returnedOrder=o1.getAddress().compareTo(o2.getAddress());break;
            case "contact": case "CONTACT": case "Contact":
                returnedOrder=o1.getContact().compareTo(o2.getContact());break;
        }
        return orderBy.equals("ascending")?returnedOrder:-returnedOrder;
//        return o1.getUsername().compareTo(o2.getUsername());
//        return o2.getUsername().compareTo(o1.getUsername());
    }
}
