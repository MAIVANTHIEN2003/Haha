package Session11.Asissgnment1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.Date;
import java.util.ResourceBundle;

public class RentController implements Initializable {
    public TableColumn<Rent,Integer> sQty;
    public TableColumn<Rent, Date> sStartDate;
    public TableColumn<Rent, Date> sEndDate;
    public TableColumn<Rent,Date> sUpdateDate;
    public TableColumn<Rent,Integer> sStatus;
    public TableColumn<Rent,String> sNote;
    public TableView tbRent;

    public final static String connectionString = "jdbc:mysql://localhost:3306/quanly";
    public final static String user = "root";
    public final static String password = "";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sQty.setCellValueFactory(new PropertyValueFactory<>("Qty"));
        sStartDate.setCellValueFactory(new PropertyValueFactory<>("StartDate"));
        sEndDate.setCellValueFactory(new PropertyValueFactory<>("EndDate"));
        sUpdateDate.setCellValueFactory(new PropertyValueFactory<>("UpdateDate"));
        sStatus.setCellValueFactory(new PropertyValueFactory<>("Status"));
        sNote.setCellValueFactory(new PropertyValueFactory<>("Note"));

        try {
            // goi driver
            Class.forName("com.mysql.jdbc.Driver");
            // tao connect
            Connection conn = DriverManager.getConnection(connectionString,user,password);
            // khai bao Statement de truy van sql
            Statement stt = conn.createStatement();
            // truy van sql
            String txt_sql = "select * from bookrents";
            ResultSet rs = stt.executeQuery(txt_sql);

            ObservableList<Rent> list = FXCollections.observableArrayList();
            while (rs.next()){
                Rent r = new Rent(
                        rs.getInt("StudentID"),
                        rs.getInt("bookID"),
                        rs.getInt("Qty"),
                        rs.getDate("StartDate"),
                        rs.getDate("EndDate"),
                        rs.getDate("UpdateDate"),
                        rs.getInt("Status"),
                        rs.getString("Note")
                );
                list.add(r);
            }
            tbRent.setItems(list);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    public void backHome(ActionEvent event)  throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        Main.rootStage.setScene(new Scene(root,800,600));
    }

    public void addRent(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("rentForm.fxml"));
        Main.rootStage.setScene(new Scene(root,800,600));
    }
}
