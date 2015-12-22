package sample.viewReportCard;

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

/**
 * Created by shestakam on 19.12.2015.
 */
public class ReportCardController {

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
        ReportCard reportCard = hibernatereportCardDao.getReportCard("student");
        ObservableList<CourseMark> data = FXCollections.observableArrayList();
        for (ReportCardItem reportCardItem : reportCard.getItemSet()) {
            CourseMark temp = new CourseMark();
            temp.courseName.setValue(reportCardItem.getCourse().getName());
            temp.mark.setValue(Integer.toString(reportCardItem.getMark()));
            data.add(temp);
        }
        reportCardTable.setItems(data);
        reportCardTable.refresh();
    }

    class CourseMark {
        public StringProperty courseName = new SimpleStringProperty("");
        public StringProperty mark = new SimpleStringProperty("");
    }
}
