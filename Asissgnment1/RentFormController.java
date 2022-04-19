package Session11.Asissgnment1;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class RentFormController {
    public final static String connectionString = "jdbc:mysql://localhost:3306/quanly";
    public final static String user = "root";
    public final static String password = "";
    public TextField sQty;
    public TextField sStartDate;
    public TextField sEndDate;
    public TextField sUpdateDate;
    public TextField sStatus;
    public TextField sNote;

    public void backRent() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("rent.fxml"));
        Main.rootStage.setScene(new Scene(root,800,600));
    }

    public void Submit(ActionEvent event) {
        String Qty = this.sQty.getText();
        String StartDate = this.sStartDate.getText();
        String EndDate = this.sEndDate.getText();
        String UpdateDate = this.sUpdateDate.getText();
        String Status = this.sStatus.getText();
        String Note = this.sNote.getText();

        String sql_txt = "insert into bookrents (Qty, StartDate, EndDate, UpdateDate, Status, Note)" + "values('"+Qty+"', '"+StartDate+"', '"+EndDate+"', '"+UpdateDate+"', '"+Status+"', '"+Note+"') ";
        System.out.println(sql_txt);
        try {

            // goi driver
            Class.forName("com.mysql.jdbc.Driver");
            // tao connect
            Connection conn = DriverManager.getConnection(connectionString,user,password);
            // khai bao Statement de truy van sql
            Statement stt = conn.createStatement();
            // insert
            stt.execute(sql_txt);
            this.backRent();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
