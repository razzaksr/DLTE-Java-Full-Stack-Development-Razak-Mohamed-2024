package handle.logs.chances;

import java.io.IOException;

public class ObjectiveOfThrows {
    public static void main(String[] args) throws IOException, InterruptedException {
        Runtime runtime=Runtime.getRuntime();
        Process process=null;
        process=runtime.exec("mspaint");
        Thread.sleep(5000);
        process=runtime.exec("control");
    }
}
