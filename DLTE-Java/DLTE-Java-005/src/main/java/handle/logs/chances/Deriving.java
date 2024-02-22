package handle.logs.chances;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.InputMismatchException;

public class Deriving extends MyBlock {
//    @Override
//    public void display()throws ClassNotFoundException{
//        System.out.println("Overridden");
//    }
    public static void main(String[] args) {
//        Deriving deriving=new Deriving();
//        deriving.display();
        MyBlock block=new MyBlock();
        try {
            block.display();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        block.decode();
    }
}
class MyBlock{
    private String mySkills="Java, Python, JavaScript, Flutter, Dotnet";
    public void display()throws FileNotFoundException {
        System.out.println(mySkills);
    }
    public void decode()throws InputMismatchException {
        String[] array=mySkills.split(",");
        System.out.println(array.length+" no of skills");
    }
}