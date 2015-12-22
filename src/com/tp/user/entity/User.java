package com.tp.user.entity;

import com.tp.course.entity.Course;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Public class <code>User/code> is one of entities
 * classes. Its content is fully consistent with Table users
 * in database, which we use for. The main role is to store
 * associated with the table information(data).
 */
@Entity
@Table(name = "users")
public class User {

    /**
     * unique identifier of instance
     */
    private Long id;

    /**
     * parameter describe username of entity
     */
    private String username;

    /**
     * parameter describe password of user
     */
    private String password;

    /**
     * parameter which contains roles of user
     */
    private Set<Role> roleSet = new HashSet<>(0);


    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Id
    @GeneratedValue
    @Column(name ="id",unique = true,nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Column(name="username",unique = true ,nullable = false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String login) {
        this.username = login;
    }

    @Column(name = "password" , nullable = false, length = 20)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles",catalog = "tp.public", joinColumns = {
            @JoinColumn(name = "user_id", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "role_id",
                    nullable = false, updatable = false) })
    public Set<Role> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<Role> roleSet) {
        this.roleSet = roleSet;
    }



}