package rmi.explore;

import app.mybank.entity.CreditCard;
import app.mybank.middleware.DatabaseTarget;
import app.mybank.services.CreditCardServices;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyCardServer extends UnicastRemoteObject implements MyCardFunctions, Serializable {

    private static Context context;
    private Registry registry;

    private CreditCardServices services;


    @Override
    public List<String> fetchOverLimit() throws RemoteException {
        List<CreditCard> cards = services.callFindAll().stream().filter(each->each.getCardUsage()>=each.getCardLimit()*0.800).collect(Collectors.toList());;
        List<String> returned=new ArrayList<>();
        for(CreditCard creditCard:cards){
            returned.add(creditCard.getCardHolder());
        }
        return returned;
    }

    public MyCardServer() throws RemoteException {
        super();
        services=new CreditCardServices(new DatabaseTarget());
        try {
            registry= LocateRegistry.createRegistry(3030);
            Hashtable properties=new Hashtable();
            properties.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.rmi.registry.RegistryContextFactory");
            properties.put(Context.PROVIDER_URL,"rmi://localhost:3030");
            context=new InitialContext(properties);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws NamingException, RemoteException {
        MyCardServer myCardServer=new MyCardServer();
        context.bind("java:/card-filter",myCardServer);
    }
}
