package com.tp.studentShedule.dao;

import com.tp.course.dao.HibernateCourseDao;
import com.tp.studentShedule.entity.Shedule;
import com.tp.user.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shestakam on 22.12.2015.
 */
public class StudentSheduleDao {

    public List<Shedule> getStudentShedules() {

        List<Shedule> studentShedules = new ArrayList<>();

        Shedule shedule = new Shedule();
        HibernateCourseDao hibernateCourseDao = new HibernateCourseDao();
        shedule.setCourses(hibernateCourseDao.getAll());
        User student = new User("student","student");
        shedule.setUser(student);
        studentShedules.add(shedule);

        return studentShedules;
    }

    public List<Shedule> getProfessorShedules() {

        List<Shedule> professorShedules = new ArrayList<>();

        Shedule shedule = new Shedule();
        HibernateCourseDao hibernateCourseDao = new HibernateCourseDao();
        shedule.setCourses(hibernateCourseDao.getAll());
        User student = new User("professor","professor");
        shedule.setUser(student);
        professorShedules.add(shedule);

        return professorShedules;
    }


}
