package elements.spring.explore;

public class CardException extends RuntimeException{
    public CardException(){
        super("Credit Card Not available");
    }
    public CardException(String info){
        super("Credit Card Not available "+info);
    }
}
