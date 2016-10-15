package ua.in.dris4ecoder.Model.businessObjects;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Alex Korneyko on 14.10.2016 18:57.
 */
@Entity
@Table(name = "groups")
public class UserGroup {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private int id;

    @Column(name = "group_name")
    private String groupName;

    @ManyToMany(cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.JOIN)
    @JoinTable(
            name = "group_authorities",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "authority")
    )
    private List<UserRoles> roles;

    public UserGroup() {
    }

    public UserGroup(String groupName) {
        this.groupName = groupName;
    }

    public UserGroup(String groupName, List<UserRoles> roles) {
        this.groupName = groupName;
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "UserGroup{" +
                "groupName='" + groupName + '\'' +
                ", roles=" + roles +
                '}';
    }
}
