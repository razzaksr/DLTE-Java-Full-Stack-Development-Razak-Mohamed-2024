package org.features.storage.fileprocessing;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.InflaterInputStream;

public class BinaryReader {
    public static void main(String[] args) throws IOException {
        File file=new File("debits.doc");
        FileInputStream fileInputStream=new FileInputStream(file);
        InflaterInputStream inflaterInputStream=new InflaterInputStream(fileInputStream);

        byte[] current=new byte[fileInputStream.available()];

        inflaterInputStream.read(current);

        System.out.println(new String(current));
        inflaterInputStream.close();
        fileInputStream.close();
    }
}
