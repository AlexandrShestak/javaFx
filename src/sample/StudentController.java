package sample;

import com.tp.db.HibernateUtil;
import com.tp.reportCard.entity.RepordCardItem;
import com.tp.reportCard.entity.ReportCard;
import com.tp.user.entity.User;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by shestakam on 19.12.2015.
 */
public class StudentController {

    public void viewReportCard() {

        System.out.println("View report card");
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List list = session.createCriteria(ReportCard.class)
                .createCriteria("user")
                .add(Restrictions.like("username", "student"))
                .list();
        System.out.println(list);
        ReportCard reportCard = (ReportCard) list.get(0);
        System.out.println(reportCard.getItemSet());
        for (RepordCardItem repordCardItem : reportCard.getItemSet()) {
            System.out.println(repordCardItem.getCourse().getName());
        }

        session.getTransaction().commit();

    }
}
