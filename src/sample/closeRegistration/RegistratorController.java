package sample.closeRegistration;

import com.tp.course.dao.HibernateCourseDao;
import com.tp.course.entity.Course;
import com.tp.paymentSystem.PaymentSystem;
import com.tp.studentShedule.dao.StudentSheduleDao;
import com.tp.studentShedule.entity.Shedule;
import com.tp.user.dao.HibernateUserDao;
import com.tp.user.entity.User;
import javafx.scene.control.Alert;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shestakam on 22.12.2015.
 */
public class RegistratorController {

    private RegistationInfoDao registationInfoDao = new RegistationInfoDao();
    private StudentSheduleDao sheduleDao = new StudentSheduleDao();
    private HibernateCourseDao hibernateCourseDao = new HibernateCourseDao();
    private HibernateUserDao hibernateUserDao = new HibernateUserDao();
    private PaymentSystem paymentSystem = new PaymentSystem();


    public void closeRegistration() {
        System.out.println("close registration");

        if (registationInfoDao.isRegistrationClosed()) {
            System.out.println("registration closed");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Registration still processed. You can't stop it now.");
            alert.showAndWait();
            return;
        }
        for (Course course : hibernateCourseDao.getAll()) {
            if (course.getProfessorCount() > 1 &&  course.getStudentCount() >10) {
                List<Shedule> studentShedules = sheduleDao.getStudentShedules();
                for (Shedule studentShedule : studentShedules) {
                    studentShedule.addCourse(course);
                }

                List<Shedule> professorShedules = sheduleDao.getProfessorShedules();
                for (Shedule professorShedule : professorShedules) {
                    professorShedule.addCourse(course);
                }
            }
        }
        List<Shedule> studentShedules = sheduleDao.getStudentShedules();
        for (Shedule studentShedule : studentShedules) {
            if (studentShedule.getCoursesCount() < 4 ) {
                studentShedule.addAlternativeCourses();
            }
        }

        for (Course course : hibernateCourseDao.getAll()) {
            course.close();
        }

        for (User user : hibernateUserDao.getAll()) {
            paymentSystem.getPayementInfo(getCourses(user));
        }


        registationInfoDao.setRegistrationStatus(true);
    }




    public List<Course> getCourses(User user) {
        return new ArrayList<>();    }
}
