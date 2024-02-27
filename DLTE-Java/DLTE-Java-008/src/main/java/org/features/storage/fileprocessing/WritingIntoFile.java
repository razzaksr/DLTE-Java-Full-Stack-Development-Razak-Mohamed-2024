package org.features.storage.fileprocessing;

import org.features.storage.eight.DebitCard;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
//import java.util.Scanner;

public class WritingIntoFile {
    public static void main(String[] args) throws IOException {
        File file=new File("debit.doc");
        FileOutputStream fileOutputStream=new FileOutputStream(file,true);
//        FileOutputStream fileOutputStream=new FileOutputStream("debit.doc");
//        Scanner scanner=new Scanner(System.in);
//        String myContent=scanner.next();
        DataInputStream dataInputStream=new DataInputStream(System.in);
        String myContent=dataInputStream.readLine();
        DebitCard debitCard=new DebitCard(876567876567L,111,2121,new Date("2/11/2031"));
        int experience=11;float place=13.5F;
        String myExists=""+experience+""+place+"\n";
        //StringBuffer buffer=new StringBuffer();buffer.append(experience);buffer.append(place);
        //System.out.println(myContent.getBytes());
        //fileOutputStream.write(myContent.getBytes());
        //fileOutputStream.write(debitCard.toString().getBytes());
//        fileOutputStream.write(buffer.toString().getBytes());
        fileOutputStream.write(myExists.getBytes());
        fileOutputStream.close();
        //dataInputStream.close();
    }
}

