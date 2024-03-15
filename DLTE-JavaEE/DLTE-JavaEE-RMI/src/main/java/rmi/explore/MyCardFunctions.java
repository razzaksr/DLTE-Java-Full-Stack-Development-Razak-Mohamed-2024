package rmi.explore;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface MyCardFunctions extends Remote {
    List<String> fetchOverLimit()throws RemoteException;
}
