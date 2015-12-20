package com.tp.course.dao;

import com.tp.course.entity.Course;
import com.tp.db.HibernateUtil;
import com.tp.user.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by shestakam on 20.12.2015.
 */
public class HibernateCourseDao {

    private  final static Logger logger = LogManager.getLogger(HibernateCourseDao.class);

    public List<Course> getAll() {
        logger.debug("get all courses");
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List result = session.createQuery("from Course").list();
        session.getTransaction().commit();
        return result;
    }
}
