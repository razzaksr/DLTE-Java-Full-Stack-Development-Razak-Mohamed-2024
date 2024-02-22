package handle.logs;

public class MySpends {
    protected String[] myBeneficiaries={"Akash","Elroy","Sabari","Mani","Annapoorna","Elizabeth","Michael","Victor","Rajkumar"};
    public final void filter(String phrase){
        for(String each:myBeneficiaries){
            if(each.startsWith(phrase))
                System.out.println(each);
        }
    }
}
