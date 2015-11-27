package com.supercow.bitted.bitted.transferObject;

/**
 * Created by paolobi on 27/11/15.
 */
public class Account implements TransferObject {
    private String user = "";
    private String password = "";
    private String name = "";
    private String surname = "";
    private String pic = "";
    private String email = "";
    private String city = "";

    public Account(String user, String password, String name, String surname,
                   String pic, String email, String city){
        this.user = user;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.pic = pic;
        this.email = email;
        this.city = city;
    }

    public Account(){

    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPic() {
        return pic;
    }

    public String getEmail() {
        return email;
    }

    public String getCity() {
        return city;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCity(String city) {
        this.city = city;
    }



    @Override
    public String toString() {
        return "Account{" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", pic='" + pic + '\'' +
                ", email='" + email + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

}
