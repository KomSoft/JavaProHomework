package com.KomSoft.lection7;

/*
    Created by Volodymyr P. Komarov aka KomSoft
*/
public class User {
    private String user;
    private String password;

    public User(String user, String password) {
        setUser(user);
        setPassword(password);
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        if(!user.isEmpty()) {
            this.user = user;
        } else {
            this.user = "user";
        }
    }

//  а это не разрешим!
/*
    public String getPassword() {
        return password;
    }
*/

    public void setPassword(String password) {
        if(!password.isEmpty()) {
            this.password = password;
        } else {
            this.password = "password";
        }
    }

    public String equals(User user) {
        if (this.user.equalsIgnoreCase(user.getUser()) && this.password.equalsIgnoreCase(user.password)) {
            return "The name and the password are equals";
        } else {
            return "The name and/or the password aren't equals";
        }
    }

    public boolean login(String name, String password) {
        return this.user.equalsIgnoreCase(name) && this.password.equals(password);
    }

    public static void main(String[] args) {
/*
        User user1 = new User("John", "1234");
        User user2 = new User("John", "1234");
        System.out.println(user1.equals(user2));
        System.out.println(user1.user);
        System.out.println(user1.password);
*/
    }
}
