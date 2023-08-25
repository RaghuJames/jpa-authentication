package org.security.model;

import jakarta.persistence.*;

@Entity
public class Authorities {
    @Id
    private String userName;
    private String authority;

    public Authorities() {
    }

    public Authorities(String authority) {
        this.authority = authority;
    }

    @OneToOne
    @MapsId
    @JoinColumn(name = "username")
    private User user;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
