package explore.oop.abstraction;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateEmail extends Backlog {
    public void alter(){
        System.out.println("Validating done with various approach");
    }
    public static void main(String[] args) {
//        Backlog backlog=new Backlog();
        ValidateEmail validateEmail=new ValidateEmail();
        validateEmail.email="razaksrmd@gmail.com";
//        validateEmail.tokenizing();
        validateEmail.regex();
        validateEmail.alter();
//        Backlog backlog=new ValidateEmail();
//        backlog.email="razaksrmd@gmail.com";
//        backlog.regex();
//        ((ValidateEmail) backlog).alter();
//        //backlog.alter();
    }

    @Override
    public void regex() {
        String regex="^[A-Za-z0-9+-_]{3,}@[a-zA-Z]{4,}\\.[a-zA-Z]{2,}$";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(email);
        if(matcher.matches())
            System.out.println("Valid email");
        else
            System.out.println("Invalid email");
    }
}
