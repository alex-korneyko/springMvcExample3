package ua.in.dris4ecoder.Model.businessObjects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Alex Korneyko on 13.10.2016 12:21.
 */
@Entity
@Table(name = "users")
public class CustomUserImpl {

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

    public CustomUserImpl(String login) {
        this.login = login;
    }

    public CustomUserImpl(String name, String surName, String login, String password, boolean enabled) {
        this.name = name;
        this.surName = surName;
        this.login = login;
        this.password = password;
        this.enabled = enabled;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomUserImpl)) return false;

        CustomUserImpl that = (CustomUserImpl) o;

        return login != null ? login.equals(that.login) : that.login == null;

    }

    @Override
    public int hashCode() {
        return login != null ? login.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "CustomUserImpl{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", login='" + login + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}
