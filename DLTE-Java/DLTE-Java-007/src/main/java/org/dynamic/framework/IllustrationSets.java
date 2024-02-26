package org.dynamic.framework;

import org.dynamic.generics.Profile;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IllustrationSets {
    public static void main(String[] args) {
        LinkedHashSet<Integer> linkedHashSet=new LinkedHashSet<>(1);
        linkedHashSet.add(98);linkedHashSet.add(232);linkedHashSet.add(112);
        linkedHashSet.add(78);linkedHashSet.add(98);linkedHashSet.add(34);

        HashSet<Integer> hashSet=new HashSet<>(linkedHashSet);
        TreeSet<Integer> treeSet=new TreeSet<>();treeSet.addAll(linkedHashSet);

//        System.out.println(linkedHashSet);
//        linkedHashSet.forEach(System.out::println);
        System.out.println("Linked Hash Set"+linkedHashSet);
        System.out.println("Hash Set"+hashSet);
        System.out.println("Tree Set"+treeSet);

        TreeSet<Profile> treeSet1=new TreeSet<>();
        Profile profile1=new Profile("razzaksr","razaksrmd","Bhanshankari,BLR",876545678987L);
        Profile profile4=new Profile("elroy","elroymite","BLR",567876567876L);
        Profile profile3=new Profile("akash","akashkannoor","Kannoor, Kerala",987654567656L);
        Profile profile2=new Profile("akshira","akshiramite","BLR",567876567876L);
        treeSet1.addAll(Stream.of(profile1,profile2,profile3,profile4).collect(Collectors.toSet()));
        treeSet1.forEach(System.out::println);
    }
}

