package database.dlte;

public class MyBankUsers {
    private String username;
    private String password;
    private String email;
    private Long contact;
    private Double balance;

    @Override
    public String toString() {
        return "MyBankUsers{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", contact=" + contact +
                ", balance=" + balance +
                '}'+"\n";
    }

    public MyBankUsers() {
    }

    public MyBankUsers(String username, String password, String email, Long contact, Double balance) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.contact = contact;
        this.balance = balance;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getContact() {
        return contact;
    }

    public void setContact(Long contact) {
        this.contact = contact;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
