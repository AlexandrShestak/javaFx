package com.tp.reportCard.entity;

import com.tp.course.entity.Course;
import com.tp.user.entity.User;

import javax.persistence.*;

/**
 * Created by shestakam on 19.12.2015.
 */
@Entity
@Table(name = "report_card_item")
public class RepordCardItem {

    @Id
    @GeneratedValue
    @Column(name = "id" , unique = true , nullable = false)
    private Long id;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id", nullable = false , insertable = false , updatable = false)
    private Course course;

    @Column(name = "mark")
    private int mark;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "report_card_id", nullable = false , insertable = false , updatable = false)
    private ReportCard reportCard;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public ReportCard getReportCard() {
        return reportCard;
    }

    public void setReportCard(ReportCard reportCard) {
        this.reportCard = reportCard;
    }
}
