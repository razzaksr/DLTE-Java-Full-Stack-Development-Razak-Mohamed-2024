package explore.oop.incorporate;

public class Customer {
    private String customerName;
    private Integer customerId;
    private Integer customerPin;

    public Customer() {
    }

    public Customer(String customerName, Integer customerId, Integer customerPin) {
        this.customerName = customerName;
        this.customerId = customerId;
        this.customerPin = customerPin;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerName='" + customerName + '\'' +
                ", customerId=" + customerId +
                ", customerPin=" + customerPin +
                '}';
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getCustomerPin() {
        return customerPin;
    }

    public void setCustomerPin(Integer customerPin) {
        this.customerPin = customerPin;
    }
}
