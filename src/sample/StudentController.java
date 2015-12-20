package sample;

import com.tp.db.HibernateUtil;
import com.tp.reportCard.dao.HibernateReportCardDao;
import com.tp.reportCard.entity.ReportCardItem;
import com.tp.reportCard.entity.ReportCard;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shestakam on 19.12.2015.
 */
public class StudentController {

    private HibernateReportCardDao hibernatereportCardDao = new HibernateReportCardDao();

    @FXML
    private TableColumn<CourseMark, String> firstNameColumn;
    @FXML
    private TableColumn<CourseMark, String> lastNameColumn;

    @FXML
    private TableView reportCardTable;

    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().courseName);
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().mark);
    }

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
        session.getTransaction().commit();
        System.out.println(reportCard.getItemSet());
        ReportCard repordCard = hibernatereportCardDao.getreportCard("student");
      /*  TableColumn firstNameCol = new TableColumn("Course name");
        TableColumn lastNameCol = new TableColumn("Mark");

        reportCardTable.getColumns().addAll(firstNameCol, lastNameCol);*/
        List data = new ArrayList();

        ObservableList<CourseMark> data1 = FXCollections.observableArrayList();

        for (ReportCardItem reportCardItem : reportCard.getItemSet()) {
            CourseMark temp = new CourseMark();
            temp.courseName.setValue(reportCardItem.getCourse().getName());
            temp.mark.setValue(Integer.toString(reportCardItem.getMark()));
            data.add(temp);
            data1.add(temp);

        }
        reportCardTable.setItems(data1);
        reportCardTable.refresh();




    }

    class CourseMark {
        public StringProperty courseName = new SimpleStringProperty("tralala");
        public StringProperty mark = new SimpleStringProperty("tralala");
    }
}
