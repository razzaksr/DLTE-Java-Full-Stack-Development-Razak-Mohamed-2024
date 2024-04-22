package business.logic;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.Collection;

@ManagedBean
//@ViewScoped
@RequestScoped
public class MyPortfolio {
    private int customerId;
    private String customerName;
    private Collection<String> stocks=new ArrayList<String>();
    private String myProfitable;
    private Collection<String> wishList=new ArrayList<>();

    public Collection<String> getWishList() {
        return wishList;
    }

    public void setWishList(Collection<String> wishList) {
        this.wishList = wishList;
    }

    public String getMyProfitable() {
        return myProfitable;
    }

    public void setMyProfitable(String myProfitable) {
        this.myProfitable = myProfitable;
    }

    @PostConstruct
    public void loading(){
        stocks.add("JSW");stocks.add("Reliance");
        stocks.add("Vedanta");stocks.add("Gold");
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Collection<String> getStocks() {
        return stocks;
    }

    public void setStocks(Collection<String> stocks) {
        this.stocks = stocks;
    }
}
