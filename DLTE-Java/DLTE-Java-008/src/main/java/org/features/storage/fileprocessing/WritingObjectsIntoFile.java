package org.features.storage.fileprocessing;

import org.features.storage.eight.DebitCard;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

public class WritingObjectsIntoFile {
    // Serialization
    public static void main(String[] args) throws IOException {
        File file=new File("D:\\Course backups\\Java\\DLithe2024Feb-Corporate-TietoEvry\\DLTE-Java Full Stack Development - Razak Mohamed\\DLTE-Java\\card.txt");
        FileOutputStream fileOutputStream=new FileOutputStream(file);
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);

        DebitCard debitCard=new DebitCard(876567876567L,111,2121,new Date("2/11/2031"));

        objectOutputStream.writeObject(debitCard);

        objectOutputStream.close();
        fileOutputStream.close();
    }
}
