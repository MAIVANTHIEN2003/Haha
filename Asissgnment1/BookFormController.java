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

public class BookFormController {
    public final static String connectionString = "jdbc:mysql://localhost:3306/quanly";
    public final static String user = "root";
    public final static String password = "";
    public TextField sbookName;
    public TextField spubliisherName;
    public TextField spubliishYear;
    public TextField sAuthor;
    public TextField sPrice;


    public void backBook() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("book.fxml"));
        Main.rootStage.setScene(new Scene(root,800,600));
    }

    public void Submit(ActionEvent event){
        String bookname = this.sbookName.getText();
        String publishername = this.spubliisherName.getText();
        String publiishyear = this.spubliishYear.getText();
        String author = this.sAuthor.getText();
        String price = this.sPrice.getText();

        String sql_txt = "insert into books (BookName,PubliisherName,PubliishYear,Author,Price)" + "values( '"+bookname+"', '"+publishername+"', '"+publiishyear+"', '"+author+"', '"+price+"')";
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
            this.backBook();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
