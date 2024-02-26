package org.dynamic.framework;

import org.dynamic.generics.Profile;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class APICall {
    public static void main(String[] args) {
        Profile profile1=new Profile("razzaksr","razaksrmd","Bhanshankari,BLR",876545678987L);
        Profile profile2=new Profile("elroy","elroymite","BLR",567876567876L);
        Profile profile3=new Profile("akash","akashkannoor","Kannoor, Kerala",987654567656L);
        Profile profile4=new Profile("akshira","akshiramite","BLR",456787654678L);
        MyBankAPI<Profile> profileAPI=new MyBankAPI<>();
//        profileAPI.insertNewRecord(profile1);
//        profileAPI.insertNewRecord(profile2);
        profileAPI.myObjects= (ArrayList<Profile>) Stream.of(profile1,profile2,profile3,profile4).collect(Collectors.toList());

        System.out.println(profileAPI.delete(3));
    }
}
