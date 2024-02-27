package org.features.storage.fileprocessing;

import org.features.storage.eight.DebitCard;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TemporaryToPermanent {
    public static void main(String[] args) throws IOException {
        List<DebitCard> debitCardList=new ArrayList<>();

        debitCardList.add(new DebitCard(87656765L,123,1111,new Date("2/29/2034")));
        debitCardList.add(new DebitCard(456754567L,999,6593,new Date("4/10/2029")));
        debitCardList.add(new DebitCard(234543454L,344,9889,new Date("6/12/2032")));
        debitCardList.add(new DebitCard(5678765678L,123,1324,new Date("7/12/2030")));

        File file=new File("D:\\Course backups\\Java\\DLithe2024Feb-Corporate-TietoEvry\\DLTE-Java Full Stack Development - Razak Mohamed\\DLTE-Java\\card.txt");
        FileOutputStream fileOutputStream=new FileOutputStream(file);
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(debitCardList);

        objectOutputStream.close();
        fileOutputStream.close();
        System.out.println("Objects are added into file");
    }
}
