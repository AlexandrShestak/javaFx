package com.tp.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by alexandr on 19.8.15.
 */


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Public class <code>Role</code> is one of entities
 * classes. Its content is fully consistent with Table roles
 * in database, which we use for. The main role is to store
 * associated with the table information(data).
 */
@Entity
@Table(name = "roles")
public class Role {

    /**
     * unique identifier of instance
     */
    @Id
    @GeneratedValue
    @Column(name = "id" , unique = true , nullable = false)
    private Long id;

    /**
     * parameter describe role name
     */
    @Column(name = "role")
    private String role;

    /**
     * parameter which contains user who have current role
     */
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "roleSet")
    private Set<User> usersSet = new HashSet<>(0);

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }


    public void setRole(String role) {
        this.role = role;
    }

    public Set<User> getUsersSet() {
        return usersSet;
    }

    public void setUsersSet(Set<User> usersSet) {
        this.usersSet = usersSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role1 = (Role) o;

        if (id != null ? !id.equals(role1.id) : role1.id != null) return false;
        return !(role != null ? !role.equals(role1.role) : role1.role != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }
}