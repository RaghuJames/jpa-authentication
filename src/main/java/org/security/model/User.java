package org.security.model;

import jakarta.persistence.*;
@Entity
@Table(name = "users")
public class User {
    public User(){}

    public User(String username, String password, int enabled) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }

    @Id
    @Column(name = "username")
    private String username;
    private String password;
    private int enabled;
    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Authorities authorities;

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

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public Authorities getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Authorities authorities) {
        this.authorities = authorities;
    }
}
