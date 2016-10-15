package ua.in.dris4ecoder.Model.businessObjects;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Alex Korneyko on 13.10.2016 12:21.
 */
@Entity
@Table(name = "users")
public class CustomUser {

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surName;

    @Id
    @Column(name = "username")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "enabled")
    private boolean enabled;

    @ManyToMany(cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.JOIN)
    @JoinTable(
            name = "group_members",
            joinColumns = @JoinColumn(name = "username"),
            inverseJoinColumns = @JoinColumn(name = "group_id")
    )
    private List<UserGroup> userGroups;

    public CustomUser() {
    }

    public CustomUser(String login) {
        this.login = login;
    }

    public CustomUser(String name, String surName, String login, String password, boolean enabled, List<UserGroup> userGroups) {
        this.name = name;
        this.surName = surName;
        this.login = login;
        this.password = password;
        this.enabled = enabled;
        this.userGroups = userGroups;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<UserGroup> getUserGroups() {
        return userGroups;
    }

    public void setUserGroups(List<UserGroup> userGroups) {
        this.userGroups = userGroups;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomUser)) return false;

        CustomUser that = (CustomUser) o;

        return login != null ? login.equals(that.login) : that.login == null;

    }

    @Override
    public int hashCode() {
        return login != null ? login.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "CustomUser{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", login='" + login + '\'' +
                ", enabled=" + enabled +
                ", userGroups=" + userGroups +
                '}';
    }
}
