package explore.oop.abstraction;

import java.util.StringTokenizer;

public abstract class Backlog {
    String email;
    public void tokenizing(){
        StringTokenizer tokenizer=new StringTokenizer(email,"@.");
//        String[] particulars=new String[tokenizer.countTokens()];
        while(tokenizer.hasMoreTokens()){
            System.out.println(tokenizer.nextToken());
        }
    }
    public abstract void regex();
}
