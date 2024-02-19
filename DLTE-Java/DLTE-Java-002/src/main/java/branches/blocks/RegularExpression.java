package branches.blocks;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {
    public static void main(String[] args) {

        // validating the numbers
        String mobileExpression="\\d{10,}";
        Pattern pattern=Pattern.compile(mobileExpression);
        Matcher matcher= pattern.matcher(args[0]);
        if(matcher.matches())
            System.out.println("Valid Mobile Number");
        else
            System.out.println("Invalid Mobile Number");


        // validating the password
        String passwordExpression="^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[@#$%_]).{8,}$";
        pattern=Pattern.compile(passwordExpression);
        matcher=pattern.matcher(args[1]);
        if(matcher.matches())
            System.out.println("Valid password");
        else
            System.out.println("Invalid password");
    }
}
