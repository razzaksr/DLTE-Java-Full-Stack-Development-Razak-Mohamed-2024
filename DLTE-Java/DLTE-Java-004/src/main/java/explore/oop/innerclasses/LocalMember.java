package explore.oop.innerclasses;

import java.io.IOException;

public class LocalMember {
    public static void main(String[] args) {
        MyICICI myICICI=new MyICICI();
        myICICI.profile();
    }
}

class MyICICI{
    public void profile(){
        int stock=5;
        class RunPrompt{
            public void myPrompt(){
                Runtime runtime=Runtime.getRuntime();
                try {
                    Process process= runtime.exec("mspaint");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        RunPrompt runPrompt=new RunPrompt();
        runPrompt.myPrompt();
    }
}
