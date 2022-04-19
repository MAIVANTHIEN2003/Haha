package Session11.Asissgnment1;

import javafx.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class StudentController implements Initializable {
    public TableView<Student> tbStudents;
    public TableColumn<Student,String> sName;
    public TableColumn<Student,Date> sBirthday;
    public TableColumn<Student,String> sAddress;
    public TableColumn<Student,String> sEmail;
    public TableColumn<Student,String> sPhone;
    public TableColumn<Student, Button> sAction;

    // tao cac string ket noi
    public final static String connectionString = "jdbc:mysql://localhost:3306/quanly";
    public final static String user = "root";
    public final static String password = "";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        sBirthday.setCellValueFactory(new PropertyValueFactory<>("Birtday"));
        sAddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
        sEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
        sPhone.setCellValueFactory(new PropertyValueFactory<>("Phone"));

        // get data from mysql
        try {
            // goi driver
            Class.forName("com.mysql.jdbc.Driver");
            // tao connect
            Connection conn = DriverManager.getConnection(connectionString,user,password);
            // khai bao Statement de truy van sql
            Statement stt = conn.createStatement();
            // truy van sql
            String txt_sql = "select * from student";
            ResultSet rs = stt.executeQuery(txt_sql);

            ObservableList<Student> list = FXCollections.observableArrayList();
            while (rs.next()){
                Student s = new Student(
                        rs.getInt("Id"),
                        rs.getString("Name"),
                        Date.valueOf(rs.getString("Birthday")),
                        rs.getString("Address"),
                        rs.getString("Email"),
                        rs.getString("Phone")
                );
                list.add(s);
            }
            tbStudents.setItems(list);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void backHome(ActionEvent event)  throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        Main.rootStage.setScene(new Scene(root,800,600));
    }

    public void addStudent(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("studentForm.fxml"));
        Main.rootStage.setScene(new Scene(root,800,600));
    }
}
