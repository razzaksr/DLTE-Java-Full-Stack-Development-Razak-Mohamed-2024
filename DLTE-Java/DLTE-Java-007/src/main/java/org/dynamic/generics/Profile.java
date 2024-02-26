package org.dynamic.generics;

public class Profile implements Comparable<Profile>{
    private String username;
    private String password;
    private String address;
    private Long contact;

    @Override
    public String toString() {
        return "Profile{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", contact=" + contact +
                '}';
    }

    public Profile() {
    }

    public Profile(String username, String password, String address, Long contact) {
        this.username = username;
        this.password = password;
        this.address = address;
        this.contact = contact;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getContact() {
        return contact;
    }

    public void setContact(Long contact) {
        this.contact = contact;
    }

    @Override
    public int compareTo(Profile o) {
//        return 0;
//        return this.username.compareTo(o.username);
        return this.contact.compareTo(o.contact);
    }
}
