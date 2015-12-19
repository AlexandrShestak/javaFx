package com.tp.reportCard.entity;

import com.tp.course.entity.Course;
import com.tp.user.entity.User;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by shestakam on 19.12.2015.
 */
@Entity
@Table(name = "report_card")
public class ReportCard {

    @Id
    @GeneratedValue
    @Column(name = "id" , unique = true , nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false , insertable = false , updatable = false)
    private User user;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "reportCard")
    private Set<RepordCardItem> itemSet;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<RepordCardItem> getItemSet() {
        return itemSet;
    }

    public void setItemSet(Set<RepordCardItem> itemSet) {
        this.itemSet = itemSet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
