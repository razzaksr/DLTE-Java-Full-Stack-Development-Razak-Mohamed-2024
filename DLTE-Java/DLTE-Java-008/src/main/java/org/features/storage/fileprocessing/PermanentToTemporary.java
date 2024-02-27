package org.features.storage.fileprocessing;

import org.features.storage.eight.DebitCard;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class PermanentToTemporary {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file=new File("D:\\Course backups\\Java\\DLithe2024Feb-Corporate-TietoEvry\\DLTE-Java Full Stack Development - Razak Mohamed\\DLTE-Java\\card.txt");
        FileInputStream fileInputStream=new FileInputStream(file);
        ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);

        List<DebitCard> debits=(List<DebitCard>) objectInputStream.readObject();

        debits.forEach(System.out::println);

        objectInputStream.close();
        fileInputStream.close();
    }
}
