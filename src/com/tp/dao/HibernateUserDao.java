package com.tp.dao;

import com.tp.HibernateUtil;
import com.tp.entities.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import java.util.List;


public class HibernateUserDao  {

    private  final static Logger logger = LogManager.getLogger(HibernateUserDao.class);


    public String save(User user) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        return user.getLogin();
    }

    public User get(String id) {
        logger.debug("get user");
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        User user = (User) session.get(User.class,id);
        session.getTransaction().commit();
        return user;
    }

    public List<User> getAll() {
        logger.debug("get all users");
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List result = session.createQuery("from User").list();
        session.getTransaction().commit();
        return result;
    }

    public void delete(String id) {
        logger.debug("delete user with username: "+id);
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        User user = (User) session.load(User.class,id);
        if (user!=null){
            session.delete(user);
        }
        session.getTransaction().commit();
    }

    public void update(User user) {
        logger.debug("update user with username: "+user.getLogin() );
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
    }
}