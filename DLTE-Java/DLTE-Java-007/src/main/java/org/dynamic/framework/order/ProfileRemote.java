package org.dynamic.framework.order;

import org.dynamic.generics.Profile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProfileRemote {
    ArrayList<Profile> myObjects=new ArrayList<>();

    public Profile readBy(String username){
        return myObjects.stream().filter(each->each.getUsername()==username).findFirst().orElse(new Profile());
    }
    public List<Profile> readBy(Long mobile){
        return myObjects.stream().filter(each->each.getContact().equals(mobile)).collect(Collectors.toList());
    }
    public String deleteBy(String username){
        boolean bool=myObjects.removeIf(each->each.getUsername()==username);
        return bool?username+" has removed":username+" not available ";
    }
    public static void main(String[] args) {
        Profile profile1=new Profile("razzaksr","razaksrmd","Bhanshankari,BLR",876545678987L);
        Profile profile2=new Profile("elroy","elroymite","BLR",567876567876L);
        Profile profile3=new Profile("akash","akashkannoor","Kannoor, Kerala",987654567656L);
        Profile profile4=new Profile("akshira","akshiramite","BLR",567876567876L);

        ProfileRemote remote=new ProfileRemote();

        remote.myObjects= (ArrayList<Profile>) Stream.of(profile1,profile2,profile3,profile4).collect(Collectors.toList());

//        System.out.println(remote.readBy(567876567876L));
//
//        System.out.println(remote.readBy("razaksr"));
//
//        System.out.println(remote.deleteBy("razzaksr"));

//        ProfileComparator myComparator=new ProfileComparator("contact:descending");
        ProfileComparator myComparator=new ProfileComparator("address:descending");

        Collections.sort(remote.myObjects,myComparator);
        remote.myObjects.forEach(System.out::println);
    }
}
