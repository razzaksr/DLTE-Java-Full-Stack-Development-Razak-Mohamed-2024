package org.dynamic.framework;

import org.dynamic.generics.Profile;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Set;
import java.util.TreeMap;

public class IllustrationMaps {
    public static void main(String[] args) {
        Hashtable<String,Double> myAsset=new Hashtable<>();
        myAsset.put("Wipro",2500.5);myAsset.put("Wipro",670.4);
        myAsset.put("JSW",893.4);myAsset.put("Gold",223.5);
        System.out.println(myAsset);
        TreeMap<String,Double> treeMap=new TreeMap<>();
        treeMap.putAll(myAsset);
        System.out.println(treeMap);

        Set<String> myOrgs = myAsset.keySet();
        System.out.println(myOrgs);
        Collection<Double> prices = treeMap.values();
        System.out.println(prices);

        myAsset.remove("Wipro");

        treeMap.replace("JSW",1900.4);
        System.out.println(treeMap);

        System.out.println(treeMap.containsKey("Wipro"));
        System.out.println(myAsset.containsValue(1900.4));

        TreeMap<Profile, String> myRepos=new TreeMap<>();
        Profile profile1=new Profile("razzaksr","razaksrmd","Bhanshankari,BLR",876545678987L);
        Profile profile4=new Profile("elroy","elroymite","BLR",567876567876L);
        Profile profile3=new Profile("akash","akashkannoor","Kannoor, Kerala",987654567656L);
        Profile profile2=new Profile("akshira","akshiramite","BLR",567876567876L);
        myRepos.put(profile1,"Kathriguppe");
        myRepos.put(profile2,"Swiss");
        myRepos.put(profile3,"BLR");
        myRepos.put(profile4,"HSR");
        System.out.println(myRepos);
    }
}
