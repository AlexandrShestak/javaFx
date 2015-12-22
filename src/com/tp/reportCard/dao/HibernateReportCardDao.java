package com.tp.reportCard.dao;

import com.tp.db.HibernateUtil;
import com.tp.reportCard.entity.ReportCard;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by shestakam on 20.12.2015.
 */
public class HibernateReportCardDao {

    public ReportCard getReportCard(String name) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List list = session.createCriteria(ReportCard.class)
                .createCriteria("user")
                .add(Restrictions.like("username", name))
                .list();
        System.out.println(list);
        ReportCard reportCard = (ReportCard) list.get(0);
        session.getTransaction().commit();

        return reportCard;
    }
}
