package branches.blocks;

public class DecodePrintln {
    public static void main(String[] args) {
        StringDecode.matchAgainstNumber("2345234");
        // System.out.println()
        StringDecode.matcher.matchCredentials("Razak@123");
    }
}

// System>> java.lang
class StringDecode{
    // instance to Passwordmatcher
    public static PasswordMatcher matcher=new PasswordMatcher();
    public static void matchAgainstNumber(String number){
        System.out.println("Test input against regex");
    }
}


// PrintStream>> java.io
class PasswordMatcher{
    // println()
    public void matchCredentials(String password){
        System.out.println("Regex pattern to have alphabets, number and special chars in password");
    }
}