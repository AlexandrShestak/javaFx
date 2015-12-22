package sample.closeRegistration;

import com.tp.db.HibernateUtil;
import org.hibernate.Session;


/**
 * Created by shestakam on 22.12.2015.
 */
public class RegistationInfoDao {

    private boolean isRegistrationClosed;

    public static boolean isRegistrationClosed() {
        //it will be better if you will not read it..
        boolean isClosed;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        isClosed = false;
        session.getTransaction().commit();
        return isClosed;
    }

    public void setRegistrationStatus(boolean status) {
        isRegistrationClosed = status;
    }
}
