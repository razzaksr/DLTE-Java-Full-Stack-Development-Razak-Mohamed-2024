package org.features.storage.fileprocessing;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadingFromFile {
    public static void main(String[] args) throws IOException {
        File file=new File("D:\\Course backups\\Java\\DLithe2024Feb-Corporate-TietoEvry\\DLTE-Java Full Stack Development - Razak Mohamed\\DLTE-Database\\DLTE-Oracle-001\\DLTE-Oracle-001-01.sql");
        FileInputStream fileInputStream=new FileInputStream(file);
        byte[] current=new byte[fileInputStream.available()];
        fileInputStream.read(current);
        String collectedData=new String(current);
        System.out.println("File contains following content\n"+collectedData);
        fileInputStream.close();
    }
}
